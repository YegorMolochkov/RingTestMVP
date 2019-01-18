package com.molochkov.ringtestmvp.screens.feed.di

import com.molochkov.ringtestmvp.core.di.annotations.ScreenScope
import com.molochkov.ringtestmvp.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.screens.feed.domain.FeedInteractor
import com.molochkov.ringtestmvp.screens.feed.domain.FeedPresenter
import com.molochkov.ringtestmvp.screens.feed.navigation.ActivityFeedRouter
import com.molochkov.ringtestmvp.screens.feed.navigation.FeedRouter
import com.molochkov.ringtestmvp.utils.Workers
import dagger.Module
import dagger.Provides

@Module
class FeedModule {

    @Provides
    @ScreenScope
    fun provideInteractor(repository: FeedRepository, workers: Workers) =
        FeedInteractor(repository, workers)

    @Provides
    @ScreenScope
    fun provideRouter(holder: NavigationHolder): FeedRouter =
        ActivityFeedRouter(holder)

    @Provides
    @ScreenScope
    fun providePresenter(interactor: FeedInteractor,
                         router: FeedRouter) =
        FeedPresenter(interactor, router)
}