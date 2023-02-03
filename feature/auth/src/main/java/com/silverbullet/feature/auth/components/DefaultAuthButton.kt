package com.silverbullet.feature.auth.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silverbullet.core.ui.BlueAccent

@Composable
fun DefaultAuthButton(
    @StringRes textRes: Int,
    callback: () -> Unit
) {
    Button(
        onClick = callback,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = BlueAccent)
    ) {
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
    }
}