package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single

class RedditFeedRepository(private val service: FeedService) : FeedRepository {

    private companion object {
        const val PAGE_SIZE = 10
    }

    override fun getFeed(lastId: String?): Single<FeedResponse> {
        return service.getFeed(PAGE_SIZE, lastId)
    }
}