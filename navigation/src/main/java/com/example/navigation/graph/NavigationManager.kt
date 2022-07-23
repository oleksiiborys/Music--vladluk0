package com.example.navigation.graph

import com.example.navigation.NavigationCommand
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    val navigationState = MutableStateFlow(AuthenticationDirections.Default)

    fun navigate(navigationCommand: NavigationCommand) {
        navigationState.value = navigationCommand
    }
}