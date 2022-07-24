package com.example.authentification.authentification.auth_impl

import com.example.authentification.authentification.auth_api.AuthApi
import com.example.moduleinjector.ComponentHolder
import dagger.Component
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import javax.inject.Singleton

object AuthComponentHolder: ComponentHolder<AuthApi, AuthDependencies> {
    private var authComponent: AuthComponent? = null

    override fun get(): AuthApi {
        checkNotNull(authComponent) { "AuthComponent is null" }
        return authComponent!!
    }

    @OptIn(InternalCoroutinesApi::class)
    override fun init(dependencies: AuthDependencies) {
        if (authComponent == null) {
            synchronized(AuthComponentHolder::class.java) {
                authComponent = AuthComponent.initAndGet(dependencies)
            }
        }
    }

    override fun reset() {
        authComponent = null
    }
}