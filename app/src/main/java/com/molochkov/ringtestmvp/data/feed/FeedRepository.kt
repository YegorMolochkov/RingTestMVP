package com.molochkov.ringtestmvp.data.feed

import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import io.reactivex.Single

/**
 * feed repository
 */
interface FeedRepository {

    /**
     * @return cached feed
     */
    fun getFeed(): Single<List<FeedEntry>>

    /**
     * @return new loaded page of feed
     */
    fun loadMoreFeed(): Single<List<FeedEntry>>
}