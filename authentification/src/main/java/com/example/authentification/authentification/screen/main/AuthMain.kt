package com.example.authentification.authentification.screen.main

import android.app.Activity.RESULT_OK
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.authentification.R
import com.example.authentification.authentification.RegistrationScreen
import com.example.music.data.repository.auth.AuthResult
import com.example.music.ui.theme.MusicTheme
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider.getCredential


@Composable
fun AuthMain(
    navController: NavController,
    viewModel: AuthViewModel
) {
    AuthMainContent(navController, viewModel)
    val context = LocalContext.current

    when(viewModel.signInState.value) {
        is AuthResult.Success -> {
            Log.d("zxc","signInState Success")
            //context.startActivity(Intent(context, MainActivity::class.java))
        }
        else -> {
            Log.d("zxc","signInState fail")
        }
    }
}

@Composable
fun AuthMainContent(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val painter = painterResource(id = R.drawable.ic_top_main_picture)
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Black),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    contentDescription = "",
                    painter = painter,
                    modifier = Modifier.aspectRatio(
                        ratio = painter.intrinsicSize.height /
                                painter.intrinsicSize.width
                    ),
                    contentScale = ContentScale.Fit,
                )
            }
        }

        Box(modifier = Modifier.weight(1f)) {
            MainBottomContent(navController, viewModel)
        }
    }
}

@Composable
fun MainBottomContent(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollableState),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Мільйони пінесь.\nСлухайте безкоштовно в Spotify",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 60.dp
            )
        )

        MainButtons(navController, viewModel)
    }
}

@Composable
fun MainButtons(
    navController: NavController,
    viewModel: AuthViewModel
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                navController.navigate(RegistrationScreen.FreeMail.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = MaterialTheme.colorScheme.surface,
            )
        ) {
            Text(
                text = "Зареєструватись безкоштовно",
                color = Color.Black,
            )
        }

        GoogleButton(viewModel)

        Button(
            onClick = {
                navController.navigate(RegistrationScreen.LogIn.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
        ) {
            Text(text = "Увійти")
        }
    }
}

@Composable
fun GoogleButton(
    viewModel: AuthViewModel
) {

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            try {
                val credentials = viewModel.oneTapClient.getSignInCredentialFromIntent(result.data)
                val googleIdToken = credentials.googleIdToken
                checkNotNull(googleIdToken) {
                    Log.d("zxc","googleIdToken null")
                }
                val googleCredentials = getCredential(googleIdToken, null)
                viewModel.signInWithGoogle(googleCredentials)
            } catch (e: ApiException) {
                Log.d("zxc", "launcher: $e")
            }
        }
    }

    fun launch(signInResult: BeginSignInResult) {
        val intent = IntentSenderRequest.Builder(signInResult.pendingIntent.intentSender).build()
        launcher.launch(intent)
    }

    when(val oneTapSignInResponse = viewModel.oneTapSignInState.value) {
        is AuthResult.Success -> {
            Log.d("zxc", "success")
            oneTapSignInResponse.data?.let {
                LaunchedEffect(it) {
                    launch(it)
                }
            }
        }
        is AuthResult.Fail -> {
            Log.d("zxc", "Fail")
        }
        else -> {}
    }

    Button(
        onClick = {
            viewModel.oneTapSignIn()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Row {
            Icon(
                painter = painterResource(
                    id = androidx.core.R.drawable.notify_panel_notification_icon_bg
                ),
                contentDescription = "",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .padding(
                        end = 5.dp
                    )
            )
            Text(text = "Продовжити за допомогою Google")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MusicTheme {
        /*AuthMainContent(
            navController = NavController(LocalContext.current),
        )*/
    }
}
