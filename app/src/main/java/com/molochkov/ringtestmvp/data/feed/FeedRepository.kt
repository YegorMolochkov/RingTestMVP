package com.molochkov.ringtestmvp.data.feed

import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import io.reactivex.Single

interface FeedRepository {

    fun getFeed(): Single<List<FeedEntry>>

    fun loadMoreFeed(): Single<List<FeedEntry>>
}