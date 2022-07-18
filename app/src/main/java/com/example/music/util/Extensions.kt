package com.example.music.util

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.music.appComponent
import com.example.music.di.DaggerScreenComponent
import javax.inject.Inject

@Inject
inline fun <reified T: ViewModel> composeViewModel(context: Context): T {
    val screenComponent = DaggerScreenComponent.factory().create(context.appComponent)
    return screenComponent.factory.create(T::class.java)
}