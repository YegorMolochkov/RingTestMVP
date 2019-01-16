package com.molochkov.ringtestmvp.screens.main.di

import android.content.Context
import com.example.gosha.ringTest.core.navigation.ActivityNavigationHolder
import com.example.gosha.ringTest.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.di.annotations.ActivityContext
import com.molochkov.ringtestmvp.core.di.annotations.ActivityScope
import com.molochkov.ringtestmvp.screens.main.MainActivity
import com.molochkov.ringtestmvp.utils.photo.GlidePhotoLoader
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): MainActivity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity

    @Provides
    @ActivityScope
    fun providePhotoLoader(@ActivityContext context: Context): PhotoLoader =
        GlidePhotoLoader(context)

    @Provides
    @ActivityScope
    fun provideNavigationHolder(): NavigationHolder =
        ActivityNavigationHolder(activity.supportFragmentManager, R.id.container)
}