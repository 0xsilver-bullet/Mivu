package com.silverbullet.mivu.feature_auth.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_auth.presentation.components.DefaultAuthButton
import com.silverbullet.mivu.navigation.utils.Screen

@Composable
fun LoginScreen(navCallback: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.request_credentials),
            style = MaterialTheme.typography.h6,
            color = TextWhiteGrey
        )
        Spacer(modifier = Modifier.height(64.dp))
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.email_address)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.password)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
            Text(
                text = stringResource(id = R.string.forgot_password),
                style = MaterialTheme.typography.h6,
                color = BlueAccent,
                modifier = Modifier.clickable { navCallback(Screen.ResetPasswordScreen) }
            )
            Spacer(modifier = Modifier.height(40.dp))
            DefaultAuthButton(textRes = R.string.login) {
                // TODO: start login process and navigate on success
                navCallback(Screen.HomeScreen)
            }
        }
    }
}