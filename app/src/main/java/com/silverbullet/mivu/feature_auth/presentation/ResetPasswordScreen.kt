package com.silverbullet.mivu.feature_auth.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.core_ui.MivuTextField
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_auth.presentation.components.DefaultAuthButton
import com.silverbullet.mivu.navigation.utils.Screen


@Composable
fun ResetPasswordScreen(navCallback: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.reset_password),
            fontSize = 28.sp,
            fontFamily = Montserrat,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.recover_password_title),
            style = MaterialTheme.typography.h5,
            color = TextGrey
        )
        Spacer(modifier = Modifier.height(48.dp))
        MivuTextField(
            value = "",
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.email_address),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(40.dp))
        DefaultAuthButton(textRes = R.string.next) { navCallback(Screen.VerifyAccountScreen) }
    }
}