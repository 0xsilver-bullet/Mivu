package com.silverbullet.mivu.core.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.silverbullet.mivu.core.presentation.ui.theme.MediumSpace


enum class DefaultListConfig {
    HORIZONTAL, VERTICAL
}

@Composable
fun DefaultList(
    modifier: Modifier = Modifier,
    title: String,
    config: DefaultListConfig = DefaultListConfig.HORIZONTAL,
    action: @Composable () -> Unit = {},
    content: LazyListScope.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
            action()
        }
        Spacer(modifier = Modifier.height(MediumSpace))
        when (config) {
            DefaultListConfig.HORIZONTAL -> LazyRow(content = { content() })
            DefaultListConfig.VERTICAL -> LazyColumn(content = { content() })
        }
    }
}