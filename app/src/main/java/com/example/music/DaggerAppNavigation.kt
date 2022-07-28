package com.example.music.util

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.authentification.authentification.auth_impl.AuthComponentHolder
import com.example.authentification.authentification.screen.main.AuthMain
import com.example.authentification.authentification.screen.main.AuthViewModel
import com.example.navigation.graph.AuthenticationDirections
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
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
        /*val viewmodel = AuthComponentHolder.get().viewModelFactory.create(AuthViewModel::class.java)
        AuthMain(navController = navController, viewModel = viewmodel)*/
    }
}

@Composable
fun Test() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "test")
    }
}


