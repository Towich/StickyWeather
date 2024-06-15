package com.towich.stickyweather.navigation

sealed class Screen(val route: String, var title: String) {
    data object CitiesScreen: Screen(route = "cities_screen", title = "CitiesScreen")
    data object InfoScreen: Screen(route = "info_screen", title = "InfoScreen")
}