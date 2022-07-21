package com.example.navigation

sealed class MainScreen(
    val route: String
) {
    open fun createRoute(root: MainScreen) = "${root.route}/$route"

    object Main : MainScreen("main")
    object Search : MainScreen("search")
    object Library : MainScreen("library")
    object Premium : MainScreen("premium")
    object Default : MainScreen("")

    object AddNewArtist: MainScreen("artistlist") {
        override fun createRoute(root: MainScreen): String {
            return "${root.route}/artistlist"
        }
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

