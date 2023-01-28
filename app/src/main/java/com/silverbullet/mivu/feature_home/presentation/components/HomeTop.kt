package com.silverbullet.mivu.feature_home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.TextGrey

@Composable
fun HomeTop(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.h4,
    subTitle: String,
    subTitleStyle: TextStyle = MaterialTheme.typography.h5,
    trailingIcon: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                stringResource(id = R.string.hello,title),
                style = titleStyle,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subTitle,
                style = subTitleStyle,
                color = TextGrey
            )
        }
        trailingIcon()
    }
}