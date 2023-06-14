package com.example.valorantwrapper.source.flow

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorantwrapper.source.ui.features.agents.AgentsView
import com.example.valorantwrapper.source.ui.features.maps.MapsView
import com.example.valorantwrapper.source.ui.features.weapons.WeaponsView

@Composable
fun FlowView(navController: NavController, paddingValues: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = BottomNavigationBarItem.Agents.id) {
        composable(BottomNavigationBarItem.Agents.id) {
            AgentsView()
        }

        composable(BottomNavigationBarItem.Maps.id) {
            MapsView()
        }

        composable(BottomNavigationBarItem.Weapons.id) {
            WeaponsView()
        }

    }
}
