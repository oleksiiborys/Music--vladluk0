package com.example.music.ui.authentification.screen.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.music.data.repository.auth.AuthRepository
import com.example.music.data.repository.auth.AuthResult
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    val oneTapClient: SignInClient,
) : ViewModel() {

    private val _signInState =
        mutableStateOf<AuthResult<Boolean>>(AuthResult.Fail)
    val signInState: State<AuthResult<Boolean>> = _signInState

    private val _oneTapSignInState =
        mutableStateOf<AuthResult<BeginSignInResult>>(AuthResult.Success(null))
    val oneTapSignInState: State<AuthResult<BeginSignInResult>> = _oneTapSignInState

    fun singInRequest() = viewModelScope.launch {
        authRepository.onTapSignInWithGoogle().collect { response ->
            _oneTapSignInState.value = response
        }
    }

    fun signInWithGoogle(googleCredential: AuthCredential) = viewModelScope.launch {
        try {
            Log.d("zxc", "signInWithGoogle")
            authRepository.firebaseSignInWithGoogle(googleCredential).collect { response ->
                _signInState.value = response
            }
        } catch (e: Exception) {
            Log.d("zxc", "signInWithGoogle $e")
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        authRepository.createUserWithEmailAndPassword(email, password).collect { response ->
            _signInState.value = response
        }
    }

    fun oneTapSignIn() = viewModelScope.launch {
        authRepository.onTapSignInWithGoogle().collect { response ->
            _oneTapSignInState.value = response
        }
    }
}