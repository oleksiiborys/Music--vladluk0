package com.example.navigation.graph

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    val navigationState = MutableStateFlow("")

    fun navigate(route: String) {
        navigationState.value = route
    }
}