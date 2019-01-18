package com.molochkov.ringtestmvp.core.di

import android.content.Context
import com.molochkov.ringtestmvp.BuildConfig
import com.molochkov.ringtestmvp.core.RingApplication
import com.molochkov.ringtestmvp.core.di.annotations.ApplicationContext
import com.molochkov.ringtestmvp.core.di.annotations.ScreenScope
import com.molochkov.ringtestmvp.core.network.RetrofitServiceProvider
import com.molochkov.ringtestmvp.core.network.ServiceProvider
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.data.feed.FeedService
import com.molochkov.ringtestmvp.data.feed.RedditFeedRepository
import com.molochkov.ringtestmvp.utils.Workers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton


@Module
class ApplicationModule(var application: RingApplication) {

    @Provides
    @ApplicationContext
    fun providesApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideWorkers(): Workers = Workers(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    fun provideServiceProvider(): ServiceProvider = RetrofitServiceProvider(BuildConfig.BASE_URL)

    @Provides
    @Singleton
    fun provideService(serviceProvider: ServiceProvider): FeedService =
        serviceProvider.createService(FeedService::class.java)

    @Provides
    @Singleton
    fun provideRepository(service: FeedService): FeedRepository =
        RedditFeedRepository(service)
}