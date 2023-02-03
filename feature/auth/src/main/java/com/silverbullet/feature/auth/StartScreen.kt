package com.silverbullet.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silverbullet.core.ui.BlueAccent
import com.silverbullet.core.ui.LocalSpacing
import com.silverbullet.core.ui.TextGrey
import com.silverbullet.feature.auth.components.DefaultAuthButton

@Composable
internal fun StartScreen(
    onLogin: () -> Unit,
    onSignup: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_logo)
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.start_text),
            style = MaterialTheme.typography.h5,
            color = TextGrey
        )
        Spacer(modifier = Modifier.height(64.dp))
        DefaultAuthButton(textRes = R.string.signup) { onSignup() }
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.have_account),
                style = MaterialTheme.typography.h4,
                color = TextGrey
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h4,
                color = BlueAccent,
                modifier = Modifier.clickable { onLogin() }
            )
        }
    }
}