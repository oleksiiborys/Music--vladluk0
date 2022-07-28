package com.example.core_firebase.core_network_impl.di

import android.content.Context
import com.example.moduleinjector.BaseImpl

interface FirebaseDependencies : BaseImpl {
    fun context(): Context
}