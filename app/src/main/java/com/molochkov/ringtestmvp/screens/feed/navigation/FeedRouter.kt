package com.molochkov.ringtestmvp.screens.feed.navigation

import android.widget.ImageView

interface FeedRouter {

    fun showImage(view: ImageView, imageUrl: String)
}