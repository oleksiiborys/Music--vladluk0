package com.example.authentification.authentification.auth_api

import com.example.base_android.di.MultiViewModelFactory
import com.example.moduleinjector.BaseApi

interface AuthApi: BaseApi {
    val viewModelFactory: MultiViewModelFactory
}