package com.silverbullet.core.data.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import javax.inject.Inject

class AndroidNetworkMonitor @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkMonitor {

    override val isOnline: Flow<Boolean> = callbackFlow {

        val connectivityManager = context.getSystemService<ConnectivityManager>()

        val callback = object : NetworkCallback() {

            override fun onAvailable(network: Network) {
                channel.trySend(connectivityManager.hasInternetConnection())
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                channel.trySend(connectivityManager.hasInternetConnection())
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                channel.trySend(connectivityManager.hasInternetConnection())
            }
        }

        connectivityManager?.registerNetworkCallback(
            NetworkRequest
                .Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build(),
            callback
        )

        channel.trySend(connectivityManager.hasInternetConnection())

        awaitClose{
            connectivityManager?.unregisterNetworkCallback(callback)
        }
    }
        .conflate()

    @Suppress("DEPRECATION")
    private fun ConnectivityManager?.hasInternetConnection(): Boolean {
        if (this == null) {
            return false
        }
        return when {
            VERSION.SDK_INT >= VERSION_CODES.M -> {
                activeNetwork?.let { network ->
                    getNetworkCapabilities(network)
                        ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                } ?: false
            }
            else -> activeNetworkInfo?.isConnected ?: false
        }
    }
}