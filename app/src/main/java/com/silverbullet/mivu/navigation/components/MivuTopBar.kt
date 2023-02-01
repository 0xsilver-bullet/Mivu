package com.silverbullet.mivu.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.core.presentation.ui.theme.Soft
import com.silverbullet.mivu.navigation.model.TopBarConfig

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
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = LocalSpacing.current.mediumSpace)
                            .size(32.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Soft)
                            .clickable {
                                topBarConfig.iconCallback?.let { callback ->
                                    callback(navController)
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = topBarConfig.iconRes),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

