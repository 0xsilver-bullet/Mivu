package com.silverbullet.mivu.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.silverbullet.core.ui.BlueAccent
import com.silverbullet.core.ui.Dark
import com.silverbullet.core.ui.Soft

private val DarkColorPalette = darkColors(
    primary = Dark,
    primaryVariant = Soft,
    secondary = BlueAccent,
    surface = Dark
)

@Composable
fun MivuTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}