package com.molochkov.ringtestmvp.screens.main.di

import android.content.Context
import com.example.gosha.ringTest.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.core.di.ApplicationComponent
import com.molochkov.ringtestmvp.core.di.annotations.ActivityContext
import com.molochkov.ringtestmvp.core.di.annotations.ActivityScope
import com.molochkov.ringtestmvp.core.di.annotations.ApplicationContext
import com.molochkov.ringtestmvp.screens.main.MainActivity
import com.molochkov.ringtestmvp.utils.Workers
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @ApplicationContext
    fun applicationContext(): Context

    @ActivityContext
    fun activityContext(): Context

    fun workers(): Workers

    fun photoLoader(): PhotoLoader

    fun navigationHolder(): NavigationHolder
}