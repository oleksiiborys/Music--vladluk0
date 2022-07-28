package com.example.music.di

import android.content.Context
import com.example.authentification.authentification.auth_api.AuthApi
import com.example.authentification.authentification.auth_impl.AuthComponentHolder
import com.example.authentification.authentification.auth_impl.AuthDependencies
import com.example.core_firebase.core_network_impl.di.FirebaseComponentHolder
import com.example.core_firebase.core_network_impl.di.FirebaseDependencies
import com.example.core_network.core_network_api.di.CoreFirebaseApi
import com.example.core_network.core_network_impl.di.CoreFirebaseComponent
import com.example.music.MainActivity
import com.example.music.MusicApplication
import com.example.navigation.graph.NavigationManager
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
    }

}

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesNavigationManager() = NavigationManager()

    @Singleton
    @Provides
    fun provideContext(): Context = MusicApplication.appContext

    @Singleton
    @Provides
    fun provideFirebaseDependencies(context: Context): FirebaseDependencies {
        return object : FirebaseDependencies {
            override fun context(): Context = context
        }
    }

    @Provides
    fun provideFirebaseApi(dependencies: FirebaseDependencies): CoreFirebaseApi {
        FirebaseComponentHolder.init(dependencies)
        return FirebaseComponentHolder.get()
    }

    @Singleton
    @Provides
    fun provideAuthFeatureDependencies(firebaseApi: CoreFirebaseApi): AuthDependencies {
        return object : AuthDependencies {
            override fun firebaseAuth(): FirebaseAuth = firebaseApi.firebaseAuth()

            override fun signInClient(): SignInClient = firebaseApi.signInClient()

            override fun firestore(): FirebaseFirestore = firebaseApi.firestore()
        }
    }

    @Singleton
    @Provides
    fun provideAuthFeatureApi(authDependencies: AuthDependencies): AuthApi {
        AuthComponentHolder.init(authDependencies)
        return AuthComponentHolder.get()
    }
}