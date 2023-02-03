package com.silverbullet.feature.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silverbullet.core.ui.LocalSpacing
import com.silverbullet.core.ui.MivuTextField
import com.silverbullet.core.ui.TextGrey
import com.silverbullet.feature.auth.components.DefaultAuthButton

@Composable
internal fun CreateNewPasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.create_new_password),
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.enter_new_password),
            fontSize = 14.sp,
            color = TextGrey
        )
        Spacer(modifier = Modifier.height(48.dp))
        MivuTextField(
            value = "",
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.new_password),
            singleLine = true,
            hideInput = true
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        MivuTextField(
            value = "",
            onValueChanged = {},
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.confirm_password),
            singleLine = true,
            hideInput = true
        )
        Spacer(modifier = Modifier.height(40.dp))
        DefaultAuthButton(textRes = R.string.reset) {}
    }
}