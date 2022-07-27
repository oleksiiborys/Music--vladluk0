package com.example.core_network.core_network_impl.di

import com.example.core_network.core_network_api.di.CoreFirebaseApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreFirebaseAuthModule::class])
abstract class CoreFirebaseComponent : CoreFirebaseApi {
    companion object {
        @Volatile
        private var coreNetworkComponent: CoreFirebaseComponent? = null

        fun get(): CoreFirebaseComponent {
            if (coreNetworkComponent == null) {
                synchronized(CoreFirebaseComponent::class) {
                    coreNetworkComponent = DaggerCoreFirebaseComponent.builder().build()
                }
            }
            return coreNetworkComponent!!
        }
    }
}