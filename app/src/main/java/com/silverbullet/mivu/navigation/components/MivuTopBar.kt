package com.silverbullet.mivu.navigation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.core_ui.MivuIconButton
import com.silverbullet.mivu.navigation.model.TopBarConfig
import com.silverbullet.mivu.R

@Composable
fun MivuTopBar(
    navController: NavController,
    topBarConfig: TopBarConfig?
) {
    if (topBarConfig != null && topBarConfig.visible) {
        TopAppBar(elevation = 0.dp) {
            Box(modifier = Modifier.fillMaxSize()) {
                if (topBarConfig.title != null) {
                    Text(
                        text = stringResource(id = topBarConfig.title),
                        style = MaterialTheme.typography.h4,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                if (topBarConfig.iconRes != null) {
                    MivuIconButton(
                        modifier = Modifier
                            .padding(start = LocalSpacing.current.mediumSpace)
                            .align(Alignment.CenterStart),
                        iconRes = R.drawable.ic_back,
                        callback = {
                            topBarConfig.iconCallback?.let { callback ->
                                callback(navController)
                            }
                        }
                    )
                }
            }
        }
    }
}

