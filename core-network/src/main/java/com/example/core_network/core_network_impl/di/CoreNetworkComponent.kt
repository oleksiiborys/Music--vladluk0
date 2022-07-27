package com.example.core_network.core_network_impl.di

import com.example.core_network.core_network_api.di.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreNetworkModule::class])
abstract class CoreNetworkComponent : CoreNetworkApi {
    companion object {
        @Volatile
        private var coreNetworkComponent: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent {
            if (coreNetworkComponent == null) {
                synchronized(CoreNetworkComponent::class) {
                    coreNetworkComponent = DaggerCoreNetworkComponent.builder().build()
                }
            }
            return coreNetworkComponent!!
        }
    }
}