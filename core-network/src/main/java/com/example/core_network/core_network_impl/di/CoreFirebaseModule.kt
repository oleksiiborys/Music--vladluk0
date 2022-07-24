package com.example.core_network.core_network_impl.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides

@Module
class CoreFirebaseModule {

    @Provides
    fun provideAuth(): FirebaseAuth = Firebase.auth
}