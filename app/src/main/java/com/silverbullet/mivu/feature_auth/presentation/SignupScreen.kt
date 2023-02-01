package com.silverbullet.mivu.feature_auth.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.core_ui.MivuTextField
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_auth.presentation.components.DefaultAuthButton

@Composable
fun SignupScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.get_started),
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.sub_signup_title),
            style = MaterialTheme.typography.h6,
            color = TextWhiteGrey
        )
        Spacer(modifier = Modifier.height(64.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            MivuTextField(
                value = "",
                onValueChanged = {},
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
                hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
                hintText = stringResource(id = R.string.full_name),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
            MivuTextField(
                value = "",
                onValueChanged = {},
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
                hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
                hintText = stringResource(id = R.string.email_address),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
            MivuTextField(
                value = "",
                onValueChanged = {},
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
                hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
                hintText = stringResource(id = R.string.password),
                singleLine = true,
                hideInput = true
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        DefaultAuthButton(textRes = R.string.signup) {}
    }
}