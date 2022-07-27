package com.example.authentification.authentification.auth_impl

import androidx.lifecycle.ViewModel
import com.example.authentification.authentification.screen.main.AuthViewModel
import com.example.base_android.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface BindsModule {

    @Binds
    @[IntoMap ViewModelKey(AuthViewModel::class)]
    fun provideAddArtistViewModel(authViewModel: AuthViewModel): ViewModel
}