package com.example.authentification.authentification

import android.content.Context
import androidx.activity.ComponentActivity


class AuthenticationActivity : ComponentActivity() {

    /*@Inject
    lateinit var auth: FirebaseAuth

    lateinit var registrationComponent: RegistrationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        //registrationComponent = appComponent.registrationComponent().bindContext(this).build()
        //registrationComponent.inject(this)
        super.onCreate(savedInstanceState)

        checkIfAuth()

        setContent {
            MusicTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    RegistrationHome()
                }
            }
        }
    }

    fun checkIfAuth() {
        if (auth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish()
        }*/
}

/*internal val Context.registrationComponent: RegistrationComponent?
    get() = when (this) {
        is AuthenticationActivity -> registrationComponent
        else -> null
    }

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MusicTheme {

    }
}*/
