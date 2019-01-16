package com.molochkov.ringtestmvp.core

import android.app.Application
import com.molochkov.ringtestmvp.core.di.ApplicationComponent
import com.molochkov.ringtestmvp.core.di.ApplicationModule
import com.molochkov.ringtestmvp.core.di.DaggerApplicationComponent

class RingApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}