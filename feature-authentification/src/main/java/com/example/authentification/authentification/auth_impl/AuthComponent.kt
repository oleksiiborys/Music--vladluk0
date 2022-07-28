package com.example.authentification.authentification.auth_impl

import com.example.authentification.authentification.auth_api.AuthApi
import dagger.Component

@Component(dependencies = [AuthDependencies::class],
        modules = [AuthFeatureModule::class])
internal abstract class AuthComponent: AuthApi {

    companion object {
        fun initAndGet(dependencies: AuthDependencies): AuthComponent {
            return DaggerAuthComponent.builder()
                .authDependencies(dependencies)
                .build()
        }
    }
}