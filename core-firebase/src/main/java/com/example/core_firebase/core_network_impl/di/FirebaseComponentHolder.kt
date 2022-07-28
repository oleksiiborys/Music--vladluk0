package com.example.core_firebase.core_network_impl.di

import com.example.core_network.core_network_api.di.CoreFirebaseApi
import com.example.core_network.core_network_impl.di.CoreFirebaseComponent
import com.example.core_network.core_network_impl.di.DaggerCoreFirebaseComponent
import com.example.moduleinjector.ComponentHolder

object FirebaseComponentHolder : ComponentHolder<CoreFirebaseApi, FirebaseDependencies> {
    var firebaseComponent: CoreFirebaseComponent? = null

    override fun get(): CoreFirebaseApi {
        checkNotNull(firebaseComponent) { "firebaseComponent null" }
        return firebaseComponent!!
    }

    override fun init(dependencies: FirebaseDependencies) {
        if (firebaseComponent == null) {
            synchronized(FirebaseComponentHolder::class) {
                firebaseComponent = CoreFirebaseComponent.initAndGet(dependencies)
            }
        }
    }

    override fun reset() {
        firebaseComponent = null
    }
}