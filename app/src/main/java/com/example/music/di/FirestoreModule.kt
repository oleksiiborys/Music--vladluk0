package com.example.music.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides

@Module
class FirestoreModule {

    @Provides
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore
}