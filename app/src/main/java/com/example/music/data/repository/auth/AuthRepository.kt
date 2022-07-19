package com.example.music.data.repository.auth

import android.util.Log
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val oneTapSignInClient: SignInClient,
    private val signInRequest: BeginSignInRequest,
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
){
    fun onTapSignInWithGoogle() = flow {
        try {
            val result = oneTapSignInClient.beginSignIn(signInRequest).await()
            emit(AuthResult.Success(result))
        } catch (exception: Exception) {
            Log.d("zxc", exception.toString())
            emit(AuthResult.Fail)
        }
    }.flowOn(Dispatchers.IO)

    fun firebaseSignInWithGoogle(googleCredential: AuthCredential) = flow {
        try {
            val authResult = auth.signInWithCredential(googleCredential).await()
            val isNewUser = authResult.additionalUserInfo?.isNewUser
            emit(AuthResult.Success(isNewUser))
        } catch (e: Exception) {
            emit(AuthResult.Fail)
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String) = flow {
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val isNewUser = result.additionalUserInfo?.isNewUser
            Log.d("zxc", isNewUser.toString())
            addUserToFireStore()
            emit(AuthResult.Success(isNewUser))
        } catch (e: Exception) {
            Log.d("zxc", e.toString())
            emit(AuthResult.Fail)
        }
    }

    private fun addUserToFireStore() {
        auth.currentUser?.uid.let { id ->
            firestore
                .collection("users")
                .add()
        }
    }
}

sealed class AuthResult<out T> {
    class Success<T>(val data: T?) : AuthResult<T>()
    object Fail: AuthResult<Nothing>()
}