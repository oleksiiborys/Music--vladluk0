package com.example.authentification.authentification.auth_impl

import android.content.Context
import com.example.moduleinjector.BaseImpl
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

interface AuthDependencies: BaseImpl {
    fun firebaseAuth(): FirebaseAuth
    fun signInClient(): SignInClient
    fun firestore(): FirebaseFirestore
}