package com.molochkov.ringtestmvp.screens.details.di

import com.molochkov.ringtestmvp.core.di.annotations.ScreenScope
import com.molochkov.ringtestmvp.screens.details.DetailsFragment
import com.molochkov.ringtestmvp.screens.main.di.MainActivityComponent
import dagger.Component

@ScreenScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface DetailsComponent {

    fun inject(fragment: DetailsFragment)
}