package com.example.core_network.core_network_impl.di

import com.example.core_firebase.core_network_impl.di.FirebaseDependencies
import com.example.core_firebase.core_network_impl.di.FirestoreModule
import com.example.core_network.core_network_api.di.CoreFirebaseApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreFirebaseAuthModule::class, FirestoreModule::class],
    dependencies = [FirebaseDependencies::class]
)
abstract class CoreFirebaseComponent : CoreFirebaseApi {
    companion object {
        fun initAndGet(dependencies: FirebaseDependencies): CoreFirebaseComponent {
            return DaggerCoreFirebaseComponent
                .builder()
                .firebaseDependencies(dependencies)
                .build()
        }

        /*fun init(): CoreFirebaseComponent {
            return DaggerCoreFirebaseComponent
                .builder()
                .build()
        }*/
    }
}