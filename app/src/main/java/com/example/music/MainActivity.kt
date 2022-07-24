package com.example.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.music.ui.theme.MusicTheme
import com.example.navigation.graph.NavigationManager
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