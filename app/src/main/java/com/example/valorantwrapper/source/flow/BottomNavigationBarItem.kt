package com.example.valorantwrapper.source.flow

import com.example.valorantwrapper.R

sealed class BottomNavigationBarItem (val title: String, val icon: Int, val id: String) {
    object Agents: BottomNavigationBarItem("Agents", R.drawable.user, "AGENTS")
    object Weapons: BottomNavigationBarItem("Weapons",  R.drawable.gun, "WEAPONS")
    object Maps: BottomNavigationBarItem("Maps",  R.drawable.maps, "MAPS")
}