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
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_auth.presentation.components.DefaultAuthButton

@Composable
fun CreateNewPasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = PaddingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.create_new_password),
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(SmallSpace))
        Text(
            text = stringResource(id = R.string.enter_new_password),
            fontSize = 14.sp,
            color = TextGrey
        )
        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.new_password)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(LargeSpace))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.confirm_password)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        DefaultAuthButton(textRes = R.string.reset) {}
    }
}