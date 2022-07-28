package com.example.core_network.core_network_impl.di

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides

@Module
class CoreFirebaseAuthModule {
    
    @Provides
    fun provideAuth(): FirebaseAuth = Firebase.auth

    @Provides
    fun provideSignIn(context: Context): SignInClient = Identity.getSignInClient(context)

    @Provides
    fun provideSignInRequest(): BeginSignInRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                //.setServerClientId(Resources.getSystem().getString(R.string.client_id))
                .setServerClientId("2958822975-r7d0bnm45v4hocqav8j5jojvs897r94o.apps.googleusercontent.com")
                .setFilterByAuthorizedAccounts(false)
                .build())
        .setAutoSelectEnabled(true)
        .build()
}