package com.example.music.app_navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.music.*
import com.example.music.addLibraryTopLevel
import com.example.music.addMainTopLevel
import com.example.music.addSearchTopLevel

/*@ExperimentalAnimationApi
@Composable
internal fun MainNavigation(
    navController: NavHostController,
    navHost: NavHost
) {
    navHost.createGraph(
        startDestination = MainScreen.Main.route,
    ) {
        addMainTopLevel(navController)
        addSearchTopLevel(navController)
        addLibraryTopLevel(navController)
        addPremiumTopLevel(navController)
    }
}

fun NavGraphBuilder.addMainTopLevel(
    navController: NavController,
) {
    navigation(
        route = MainScreen.Main.route,
        startDestination = MainScreen.Main.createRoute(MainScreen.Main)
    ) {
        addMain(navController, MainScreen.Main)
    }
}

fun NavGraphBuilder.addLibraryTopLevel(
    navController: NavController,
) {
    navigation(
        route = MainScreen.Library.route,
        startDestination = MainScreen.Library.createRoute(MainScreen.Library)
    ) {
        addLibrary(navController, MainScreen.Library)
        addArtistList(navController, MainScreen.Library)
    }
}

fun NavGraphBuilder.addSearchTopLevel(
    navController: NavController,
) {
    navigation(
        route = MainScreen.Search.route,
        startDestination = MainScreen.Search.createRoute(MainScreen.Search)
    ) {
        addSearch(navController, MainScreen.Search)
    }
}

fun NavGraphBuilder.addPremiumTopLevel(
    navController: NavController,
) {
    navigation(
        route = MainScreen.Premium.route,
        startDestination = MainScreen.Premium.createRoute(MainScreen.Premium)
    ) {
        addPremium(navController, MainScreen.Premium)
    }
}

fun NavGraphBuilder.addMain(
    navController: NavController,
    root: MainScreen
) {
    composable(
        route = MainScreen.Main.createRoute(root),
    ) {
        Main()
    }
}

fun NavGraphBuilder.addLibrary(
    navController: NavController,
    root: MainScreen
) {
    composable(
        route = MainScreen.Library.createRoute(root),
    ) {
        val screenComponent = DaggerScreenComponent.factory().create(LocalContext.current.appComponent)
        val viewModel = screenComponent.factory.create(LibraryVM::class.java)
        Library(
            viewModel = viewModel,
            addNewArtist = {
                navController.navigate(MainScreen.AddNewArtist.createRoute(root))
            }
        )
    }
}

fun NavGraphBuilder.addSearch(
    navController: NavController,
    root: MainScreen
) {
    composable(
        route = MainScreen.Search.createRoute(root),
    ) {
        Search()
    }
}

fun NavGraphBuilder.addPremium(
    navController: NavController,
    root: MainScreen
) {
    composable(
        route = MainScreen.Premium.createRoute(root),
    ) {
        Premium()
    }
}

fun NavGraphBuilder.addArtistList(
    navController: NavController,
    root: MainScreen
) {
    composable(
        route = MainScreen.AddNewArtist.createRoute(root),
    ) {
        val screenComponent = DaggerScreenComponent.factory().create(LocalContext.current.appComponent)
        val viewModel = screenComponent.factory.create(AddArtistVM::class.java)
        AddArtist(viewModel)
    }
}*/