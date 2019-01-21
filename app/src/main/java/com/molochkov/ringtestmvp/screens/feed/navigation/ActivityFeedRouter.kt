package com.molochkov.ringtestmvp.screens.feed.navigation

import com.molochkov.ringtestmvp.core.navigation.NavigationHolder
import com.molochkov.ringtestmvp.screens.details.ui.DetailsFragment

class ActivityFeedRouter(private val holder: NavigationHolder) : FeedRouter {

    override fun showImage(imageUrl: String) {
        holder.showFragment(DetailsFragment.newInstance(imageUrl))
    }
}