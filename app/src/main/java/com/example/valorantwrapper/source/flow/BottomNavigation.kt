package com.example.valorantwrapper.source.flow


import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavigationBarItem.Agents,
        BottomNavigationBarItem.Maps,
        BottomNavigationBarItem.Weapons
    )


    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach {
            NavigationBarItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = it.title, modifier = Modifier.size(16.dp)) },
                label = { Text(text = it.title, fontSize = 9.sp) },
                alwaysShowLabel = true,
                selected = currentRoute == it.id,
                onClick = {
                    navController.navigate(it.id) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
