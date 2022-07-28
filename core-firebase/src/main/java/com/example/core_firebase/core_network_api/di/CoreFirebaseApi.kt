package com.example.core_network.core_network_api.di

import android.content.Context
import com.example.moduleinjector.BaseApi
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

interface CoreFirebaseApi : BaseApi {
    fun firebaseAuth(): FirebaseAuth
    fun signInClient(): SignInClient
    fun beginSignInRequest(): BeginSignInRequest
    fun firestore(): FirebaseFirestore
}