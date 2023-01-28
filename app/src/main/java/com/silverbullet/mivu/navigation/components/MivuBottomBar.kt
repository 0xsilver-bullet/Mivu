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
import androidx.navigation.NavController
import com.silverbullet.mivu.core.presentation.ui.theme.BlueAccent
import com.silverbullet.mivu.core.presentation.ui.theme.Soft
import com.silverbullet.mivu.navigation.model.BottomNavItemInfo

@Composable
fun MivuBottomBar(
    isVisible: Boolean,
    defaultRoute: String,
    currentRoute: String,
    navItems: List<BottomNavItemInfo>,
    horizontalPadding: Dp = 45.dp,
    navController: NavController
) {
    if (isVisible) {
        BottomAppBar(modifier = Modifier.height(72.dp)) {
            BottomNavigation(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = horizontalPadding),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    navItems.forEach { navItemInfo ->
                        NavItem(
                            active = navItemInfo.route == currentRoute,
                            itemInfo = navItemInfo
                        ) { route ->
                            navController.navigate(route){
                                if(route == defaultRoute){
                                    launchSingleTop = true
                                }
                                popUpTo(defaultRoute)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavItem(
    active: Boolean,
    itemInfo: BottomNavItemInfo,
    selectedColor: Color = BlueAccent,
    selectedBackgroundColor: Color = Soft,
    defaultColor: Color = Color.Gray,
    navCallback: (String) -> Unit
) {

    val itemColor = if (active) selectedColor else defaultColor
    val boxModifier = if (active) {
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(selectedBackgroundColor)
            .clickable { }
            .padding(12.dp)
    } else {
        Modifier
            .clickable { navCallback(itemInfo.route) }
            .padding(12.dp)
    }

    Box(modifier = boxModifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = itemInfo.icon),
                contentDescription = null,
                tint = itemColor
            )
            if (active) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = itemInfo.title),
                    style = MaterialTheme.typography.h6,
                    color = itemColor
                )
            }
        }
    }
}