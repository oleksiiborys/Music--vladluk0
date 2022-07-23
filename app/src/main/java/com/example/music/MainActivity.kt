package com.example.music

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import com.example.music.di.ApplicationComponent
import com.example.music.di.DaggerApplicationComponent
import com.example.music.ui.screen.add_artist.AddArtist
import com.example.music.ui.screen.add_artist.AddArtistVM

import com.example.music.ui.theme.MusicTheme
import com.example.navigation.graph.NavigationManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            MusicTheme {
                navigationManager.navigationState.collectAsState().value.also { command ->
                    if (command.destination.isNotEmpty()) {
                        navigationManager.navigate(command)
                    }
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    HomeMulti()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MusicTheme {
        //AddArtist()
    }
}