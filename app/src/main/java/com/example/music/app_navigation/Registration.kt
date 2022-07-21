package com.example.music.app_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.music.Screen
import com.example.music.ui.authentification.registrationComponent
import com.example.music.ui.authentification.screen.free_registration.FreeRegistrationMail
import com.example.music.ui.authentification.screen.free_registration.FreeRegistrationPassword
import com.example.music.ui.authentification.screen.log_in.LogIn
import com.example.music.ui.authentification.screen.main.AuthMain
import com.example.music.ui.authentification.screen.main.AuthViewModel
import com.example.navigation.RegistrationScreen

@Composable
fun RegistrationNavigation(
    navController: NavHostController,
    navHost: NavHost
) {
    navHost.createGraph(
        startDestination = RegistrationScreen.Main.route
    ) {
        addMain(navController)
        addFreeMail(navController)
        addFreePassword(navController)
        addLogin(navController)
    }
}

fun NavGraphBuilder.addMain(
    navController: NavController
) {
    composable(
        route = Screen.Main.route
    ) {
        val context = LocalContext.current
        val registrationComponent = context.registrationComponent
        checkNotNull(registrationComponent) { "registrationComponent null" }
        val viewModel = registrationComponent.factory.create(AuthViewModel::class.java)
        AuthMain(navController, viewModel)
    }
}

fun NavGraphBuilder.addFreeMail(
    navController: NavController,
) {
    composable(
        route = RegistrationScreen.FreeMail.route
    ) {
        FreeRegistrationMail(navController)
    }
}

fun NavGraphBuilder.addFreePassword(
    navController: NavController,
) {
    composable(
        route = RegistrationScreen.FreePassword.route
    ) { backStackEntry ->
        val mail = backStackEntry.arguments?.getString("mail")
        checkNotNull(mail) { "mail in null" }

        val context = LocalContext.current
        val registrationComponent = context.registrationComponent
        checkNotNull(registrationComponent) { "registrationComponent null" }
        val viewModel = registrationComponent.factory.create(AuthViewModel::class.java)

        FreeRegistrationPassword(navController, viewModel, mail)
    }
}

fun NavGraphBuilder.addLogin(
    navController: NavController,
) {
    composable(
        route = RegistrationScreen.LogIn.route
    ) {
        LogIn(navController = navController)
    }
}