package com.molochkov.ringtestmvp.screens.main.di

import android.content.Context
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.di.annotations.ActivityContext
import com.molochkov.ringtestmvp.core.di.annotations.ActivityScope
import com.molochkov.ringtestmvp.core.navigation.ActivityNavigationHolder
import com.molochkov.ringtestmvp.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.screens.main.ui.MainActivity
import com.molochkov.ringtestmvp.screens.main.domain.MainPresenter
import com.molochkov.ringtestmvp.screens.main.navigation.ActivityMainRouter
import com.molochkov.ringtestmvp.screens.main.navigation.MainRouter
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
        ActivityNavigationHolder(activity.supportFragmentManager, R.id.mainFrame)

    @Provides
    @ActivityScope
    fun provideRouter(holder: NavigationHolder): MainRouter =
        ActivityMainRouter(holder)

    @Provides
    @ActivityScope
    fun providePresenter(router: MainRouter) = MainPresenter(router)
}