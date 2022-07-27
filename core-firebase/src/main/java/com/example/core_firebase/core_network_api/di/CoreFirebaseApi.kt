package com.example.core_network.core_network_api.di

import com.example.moduleinjector.BaseApi
import com.google.firebase.auth.FirebaseAuth

interface CoreFirebaseApi : BaseApi {
    fun firebaseAuth(): FirebaseAuth
}