package com.molochkov.ringtestmvp.screens.feed.di

import com.molochkov.ringtestmvp.core.di.annotations.ScreenScope
import com.molochkov.ringtestmvp.screens.feed.ui.FeedFragment
import com.molochkov.ringtestmvp.screens.main.di.MainActivityComponent
import dagger.Component

@ScreenScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FeedModule::class]
)
interface FeedComponent {

    fun inject(fragment: FeedFragment)
}