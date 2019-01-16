package com.molochkov.ringtestmvp.screens.feed.di

import com.molochkov.ringtestmvp.core.di.annotations.ScreenScope
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.data.feed.RedditFeedRepository
import com.molochkov.ringtestmvp.screens.feed.FeedPresenter
import com.molochkov.ringtestmvp.screens.feed.domain.FeedInteractor
import com.molochkov.ringtestmvp.utils.Workers
import dagger.Module
import dagger.Provides

@Module
class FeedModule {

    @Provides
    @ScreenScope
    fun provideRepository(): FeedRepository = RedditFeedRepository()

    @Provides
    @ScreenScope
    fun provideInteractor(repository: FeedRepository, workers: Workers) =
        FeedInteractor(repository, workers)

    @Provides
    @ScreenScope
    fun providePresenter(interactor: FeedInteractor) =
        FeedPresenter(interactor)
}