package com.silverbullet.feature.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silverbullet.core.ui.BlueAccent
import com.silverbullet.core.ui.LocalSpacing
import com.silverbullet.core.ui.TextGrey
import com.silverbullet.feature.auth.components.DefaultAuthButton
import com.silverbullet.feature.auth.components.VerifyKeyInput

@Composable
internal fun VerifyAccountScreen(
    onVerified: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = stringResource(id = R.string.verify_account),
            style = MaterialTheme.typography.h2,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.mediumSpace))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontSize = 14.sp, color = Color(0xFF7F7E83))) {
                    append(stringResource(id = R.string.verify_sub_title))
                }
                withStyle(SpanStyle(fontSize = 14.sp, color = Color.White)) {
                    append(" ")
                    append(stringResource(id = R.string.example_email))
                }
            },
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))

        var input by remember {
            mutableStateOf("")
        }
        VerifyKeyInput(
            value = input,
            onValueChanged = { input = it },
            textStyle = MaterialTheme.typography.h1,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(64.dp))
        DefaultAuthButton(textRes = R.string.continue_text) { onVerified() }
        Spacer(modifier = Modifier.height(48.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.resend_code),
                style = MaterialTheme.typography.h4,
                color = TextGrey
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(id = R.string.resend),
                style = MaterialTheme.typography.h4,
                color = BlueAccent
            )
        }
    }
}