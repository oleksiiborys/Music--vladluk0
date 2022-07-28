package com.example.music

import android.app.Application
import android.content.Context
import com.example.music.di.ApplicationComponent
import com.example.music.di.DaggerApplicationComponent

class MusicApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().build()
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}

val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is MusicApplication -> appComponent
        else -> this.applicationContext.appComponent
    }
