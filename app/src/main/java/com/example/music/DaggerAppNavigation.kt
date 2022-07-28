package com.example.music.util

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.authentification.authentification.auth_impl.AuthComponentHolder
import com.example.authentification.authentification.screen.main.AuthMain
import com.example.navigation.graph.AuthenticationDirections

@ExperimentalAnimationApi
@Composable
internal fun DaggerAppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AuthenticationDirections.root.destination,
        modifier = modifier,
    ) {
        authAddMainTopLvl(navController)
    }
}

fun NavGraphBuilder.authAddMainTopLvl(
    navController: NavController,
) {
    navigation(
        route = AuthenticationDirections.root.destination,
        startDestination = AuthenticationDirections.main.destination
    ) {
        addMain(navController)
    }
}

fun NavGraphBuilder.addMain(
    navController: NavController,
) {
    composable(
        route = AuthenticationDirections.main.destination,
    ) {

    }
}

@Composable
fun Test() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "test")
    }
}


