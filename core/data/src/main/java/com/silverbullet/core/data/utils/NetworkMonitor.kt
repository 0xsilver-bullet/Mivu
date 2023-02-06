package com.silverbullet.core.data.utils

import kotlinx.coroutines.flow.Flow

/**
 * Reports the network state for the application
 */
interface NetworkMonitor {

    val isOnline: Flow<Boolean>
}