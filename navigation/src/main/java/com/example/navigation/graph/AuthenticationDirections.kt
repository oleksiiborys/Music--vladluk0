package com.example.navigation.graph

import androidx.navigation.NamedNavArgument
import com.example.navigation.NavigationCommand

object AuthenticationDirections {

    val main = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "main"
    }

    val freeMail = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "freemail"
    }

    val freePass = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "freepass"
    }

    val logIn = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "login"
    }

    val root = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = "connect"
    }

    val Default = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>?
            get() = null
        override val destination: String
            get() = ""
    }
}

sealed class RegistrationScreen(val route: String) {

    open fun createRoute(root: RegistrationScreen) = "${root.route}/$route"

    object Main : RegistrationScreen("main")

    object FreeMail : RegistrationScreen("main/free")

    object FreePassword : RegistrationScreen("main/free/mail/{mail}/password") {
        fun createRoute(mail: String): String {
            return "main/free/mail/$mail/password"
        }
    }

    object LogIn : RegistrationScreen("main/login")
}