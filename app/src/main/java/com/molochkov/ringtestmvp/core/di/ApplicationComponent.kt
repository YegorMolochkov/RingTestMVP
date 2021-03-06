package com.molochkov.ringtestmvp.core.di

import android.content.Context
import com.molochkov.ringtestmvp.core.RingApplication
import com.molochkov.ringtestmvp.core.di.annotations.ApplicationContext
import com.molochkov.ringtestmvp.core.network.ServiceProvider
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.utils.Workers
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: RingApplication)

    @ApplicationContext
    fun applicationContext(): Context

    fun workers(): Workers

    fun serviceProvider(): ServiceProvider

    fun feedRepository(): FeedRepository
}