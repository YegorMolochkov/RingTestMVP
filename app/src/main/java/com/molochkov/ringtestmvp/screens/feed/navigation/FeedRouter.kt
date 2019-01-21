package com.molochkov.ringtestmvp.screens.feed.navigation

/**
 * feed screen router
 */
interface FeedRouter {

    /**
     * show full sized image screen
     * @param imageUrl image URL
     */
    fun showImage(imageUrl: String)
}