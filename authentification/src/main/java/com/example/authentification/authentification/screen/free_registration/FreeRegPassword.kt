package com.example.authentification.authentification.screen.free_registration

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.music.data.repository.auth.AuthResult
import com.example.music.ui.common.field.PasswordField

import com.example.music.ui.theme.MusicTheme

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeRegistrationPassword(
    navController: NavController,
    viewModel: AuthViewModel,
    email: String
) {
    Scaffold(
        topBar = {
            SimpleAppBar(
                navController,
                title = "Створення акаунту"
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black)
        ) {
            FreeRegContent(
                viewModel,
                email = email
            )
        }
    }
}

@Composable
fun FreeRegContent(
    viewModel: AuthViewModel,
    email: String
) {

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(
            start = 10.dp/*MaterialTheme.padding.start,*/,
            end = 10.dp/*MaterialTheme.padding.end*/
        ),
    ) {
        PasswordField(
            modifier = Modifier.padding(
                top = 50.dp
            ),
            textField = "Створіть пароль",
            onEmailChange = {
                password = it
            },
            password = password
        )

        CreateAccountButton(
            viewModel,
            email = email,
            password = password
        )
    }
}

@Composable
fun CreateAccountButton(
    viewModel: AuthViewModel,
    email: String,
    password: String
) {
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                viewModel.createUserWithEmailAndPassword(email, password)
                /*FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        context.startActivity(Intent(context, MainActivity::class.java))
                    }
                }*/
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            modifier = Modifier.padding(
                top = 10.dp
            )
        ) {
            Text(
                text = "Створити акаунт",
                color = Color.Black
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FreeRegistrationPreview() {
    MusicTheme {
        /*FreeRegistrationPassword(
            navController = NavController(LocalContext.current),
            email = ""
        )*/
    }
}*/
