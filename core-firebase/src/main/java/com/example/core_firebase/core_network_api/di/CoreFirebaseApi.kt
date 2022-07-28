package com.example.core_network.core_network_api.di

import com.example.moduleinjector.BaseApi
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth

interface CoreFirebaseApi : BaseApi {
    fun firebaseAuth(): FirebaseAuth
    //fun signInClient(): SignInClient
    fun beginSignInRequest(): BeginSignInRequest
}