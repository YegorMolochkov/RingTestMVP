package com.molochkov.ringtestmvp.screens.main.navigation

import com.molochkov.ringtestmvp.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.screens.feed.FeedFragment

class ActivityMainRouter(private val holder: NavigationHolder) : MainRouter {

    override fun showStartScreen() {
        holder.showFragment(FeedFragment.newInstance())
    }
}