package com.silverbullet.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchTextInput(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    hint: String = "",
    value: String,
    textStyle: TextStyle = MaterialTheme.typography.h5,
    onValueChanged: (String) -> Unit,
    backgroundColor: Color = Soft,
    singleLine: Boolean = true
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(backgroundColor)
            .defaultMinSize(minHeight = 42.dp)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if(leadingIcon != null){
                leadingIcon()
                Spacer(modifier = Modifier.width(4.dp))
            }
            Box {
                if(value.isEmpty()){
                    Text(
                        text = hint,
                        style = textStyle
                    )
                }
                BasicTextField(
                    value = value,
                    onValueChange = onValueChanged,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = textStyle.copy(),
                    singleLine = singleLine
                )
            }
        }
    }
}