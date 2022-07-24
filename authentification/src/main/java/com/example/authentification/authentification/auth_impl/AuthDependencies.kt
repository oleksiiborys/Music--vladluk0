package com.example.authentification.authentification.auth_impl

import com.example.moduleinjector.BaseImpl
import com.google.firebase.auth.FirebaseAuth

interface AuthDependencies: BaseImpl {
    fun firebaseAuth(): FirebaseAuth
}