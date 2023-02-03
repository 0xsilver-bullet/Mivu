package com.silverbullet.mivu.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.silverbullet.core.ui.BlueAccent
import com.silverbullet.core.ui.Soft
import com.silverbullet.mivu.navigation.utils.TopLevelDestination

@Composable
fun MivuBottomBar(
    isVisible: Boolean,
    currentDestination: NavDestination?,
    destinations: List<TopLevelDestination>,
    horizontalPadding: Dp = 45.dp,
    onNavigateToDestination: (TopLevelDestination) -> Unit
) {
    if(isVisible) {
        BottomNavigation(
            modifier = Modifier
                .height(72.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = horizontalPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                destinations.forEach { destination ->
                    NavItem(
                        selected = currentDestination.isTopLevelDestinationInHierarchy(
                            destination
                        ),
                        destination = destination
                    ) { onNavigateToDestination(it) }
                }
            }
        }
    }
}


@Composable
fun NavItem(
    selected: Boolean,
    destination: TopLevelDestination,
    selectedColor: Color = BlueAccent,
    selectedBackgroundColor: Color = Soft,
    defaultColor: Color = Color.Gray,
    onClick: (TopLevelDestination) -> Unit
) {

    val itemColor = if (selected) selectedColor else defaultColor
    val boxModifier = if (selected) {
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(selectedBackgroundColor)
            .clickable { }
            .padding(12.dp)
    } else {
        Modifier
            .clickable { onClick(destination) }
            .padding(12.dp)
    }

    Box(modifier = boxModifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = destination.iconId),
                contentDescription = null,
                tint = itemColor
            )
            if (selected) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = destination.titleId),
                    style = MaterialTheme.typography.h6,
                    color = itemColor
                )
            }
        }
    }
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination): Boolean {
    return this?.hierarchy?.any {
        it.route?.contains(destination.name, ignoreCase = true) ?: false
    } ?: false
}