package com.example.authentification.authentification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.music.MainActivity
import com.example.music.di.registration.RegistrationComponent
import com.example.music.ui.theme.MusicTheme
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthenticationActivity : ComponentActivity() {

    /*@Inject
    lateinit var auth: FirebaseAuth*/

    lateinit var registrationComponent: RegistrationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        //registrationComponent = appComponent.registrationComponent().bindContext(this).build()
        //registrationComponent.inject(this)
        super.onCreate(savedInstanceState)

        //checkIfAuth()

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

    /*fun checkIfAuth() {
        if (auth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish()
        }
    }*/
}

internal val Context.registrationComponent: RegistrationComponent?
    get() = when (this) {
        is AuthenticationActivity -> registrationComponent
        else -> null
    }

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MusicTheme {

    }
}
