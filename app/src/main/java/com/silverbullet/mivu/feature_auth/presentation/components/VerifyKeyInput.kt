package com.silverbullet.mivu.feature_auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.presentation.ui.theme.BlueAccent
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing
import com.silverbullet.mivu.core.presentation.ui.theme.Soft
import timber.log.Timber

@Composable
fun VerifyKeyInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    textStyle: TextStyle,
    textColor: Color = Color.White,
    boxSize: Dp = 64.dp,
    boxColor: Color = Soft,
    borderColor: Color = BlueAccent,
    keySpace: Dp = LocalSpacing.current.mediumSpace,
    keyBorderRadius: Dp = 12.dp,
    keyLength: Int = 4,
) {

    val text = value.toList().filter { it != ' ' }.toList().take(4)

    Timber.d("Current Text: $value")

    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            for (i in 0 until keyLength) {
                val isBoxHighlighted = i == 0 || (text.getOrNull(i) != null)
                var keyModifier = Modifier
                    .size(boxSize)
                    .clip(RoundedCornerShape(keyBorderRadius))
                if (isBoxHighlighted) {
                    keyModifier = keyModifier.then(
                        Modifier.border(
                            width = 1.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(keyBorderRadius)
                        )
                    )
                }
                keyModifier = keyModifier.then(Modifier.background(boxColor))
                Box(
                    modifier = keyModifier,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text.getOrNull(i)?.toString() ?: "",
                        color = textColor,
                        style = textStyle
                    )
                }
                if (i != keyLength - 1) {
                    Spacer(modifier = Modifier.width(keySpace))
                }
            }
        }
        BasicTextField(
            value = text.joinToString(separator = ""),
            onValueChange = {
                if (it.length <= keyLength) {
                    onValueChanged(it)
                }
            },
            singleLine = true,
            modifier = Modifier
                .matchParentSize()
                .alpha(0.0f)

        )
    }
}