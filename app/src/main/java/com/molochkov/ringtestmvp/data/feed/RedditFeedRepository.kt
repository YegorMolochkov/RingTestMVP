package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single

class RedditFeedRepository(private val service: FeedService) : FeedRepository {

    override fun getFeed(): Single<FeedResponse> {
        return service.getFeed()
    }
}