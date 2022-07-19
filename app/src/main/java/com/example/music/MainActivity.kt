package com.example.music

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.music.di.DaggerApplicationComponent
import com.example.music.ui.screen.add_artist.AddArtist
import com.example.music.ui.screen.add_artist.AddArtistVM

import com.example.music.ui.theme.MusicTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    val db = Firebase.firestore
    val auth = Firebase.auth

    protected val currentUser: FirebaseUser?
        get() = auth.currentUser

    val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("zxc", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("zxc", "Error adding document", e)
            }

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("zxc", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("zxc", "Error getting documents.", exception)
            }

        setContent {

            MusicTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    //AddArtist(viewModel = viewModel)
                    Home()
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