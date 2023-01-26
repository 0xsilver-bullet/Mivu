package com.silverbullet.mivu.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.silverbullet.mivu.core.presentation.ui.theme.MivuTheme
import com.silverbullet.mivu.core.presentation.ui.theme.TextWhiteGrey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MivuTheme {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Android",
                            style = MaterialTheme.typography.h1,
                            color = TextWhiteGrey,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}