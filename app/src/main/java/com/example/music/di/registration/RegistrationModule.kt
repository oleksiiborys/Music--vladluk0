package com.example.music.di.registration

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.music.di.ViewModelKey
import com.example.authentification.authentification.screen.main.AuthViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [BindsModule::class]
)
class RegistrationModule {

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

@Module
interface BindsModule {
    @Binds
    @[IntoMap ViewModelKey(AuthViewModel::class)]
    fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}