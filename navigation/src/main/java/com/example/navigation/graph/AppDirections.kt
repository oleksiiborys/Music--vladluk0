package com.example.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>?
    val destination: String
}

object MainNavigation {

    val main = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "main"
    }

    val search = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "search"
    }

    val library = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "library"
    }

    val premium = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "premium"
    }
}

sealed class Screen(
    val route: String
) {
    object Main : Screen("main")
    object Search : Screen("search")
    object Library : Screen("library")
    object Premium : Screen("premium")
}

private sealed class LeafScreen(
    private val route: String
) {
    open fun createRoute(root: Screen) = "${root.route}/$route"

    object Main : LeafScreen("main")
    object Search : LeafScreen("search")
    object Library : LeafScreen("library")
    object Premium : LeafScreen("premium")

    object AddNewArtist: LeafScreen("artistlist") {
        override fun createRoute(root: Screen): String {
            return "${root.route}/artistlist"
        }
    }
}

