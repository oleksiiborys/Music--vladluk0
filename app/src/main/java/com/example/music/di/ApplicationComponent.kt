package com.example.music.di

import com.example.music.MainActivity
import com.example.music.data.remote.ArtistsService
import com.example.music.di.registration.RegistrationComponent
import com.example.navigation.graph.NavigationManager
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun artistService(): ArtistsService

    fun registrationComponent() : RegistrationComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
    }
}

@Module(
    includes = [
        NetworkModule::class,
        FirebaseModule::class,
        FirestoreModule::class,
        AppSubComponent::class
    ]
)
class AppModule {

    @Singleton
    @Provides
    fun provideNavigationManager() = NavigationManager()
}

@Module(
    subcomponents = [RegistrationComponent::class]
)
interface AppSubComponent