package com.example.music.data.repository.auth

/*class AuthRepository @Inject constructor(
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

        }
    }
}*/

sealed class AuthResult<out T> {
    class Success<T>(val data: T?) : AuthResult<T>()
    object Fail: AuthResult<Nothing>()
}