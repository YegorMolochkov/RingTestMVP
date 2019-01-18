package com.molochkov.ringtestmvp.data.feed

import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.data.toFeedEntry
import io.reactivex.Single

class RedditFeedRepository(private val service: FeedService) : FeedRepository {

    private companion object {
        const val PAGE_SIZE = 10
    }

    private var lastId: String? = null
    private val feed = mutableListOf<FeedEntry>()

    override fun getFeed(): Single<List<FeedEntry>> {
        return Single.just(feed)
    }

    override fun loadMoreFeed(): Single<List<FeedEntry>> {
        return service.getFeed(PAGE_SIZE, lastId)
//            .delay(10L, TimeUnit.SECONDS)
            .doOnSuccess {
                lastId = it.data.after
            }.map { response ->
                response.data.children.map { it.data.toFeedEntry() }
            }.doOnSuccess {
                feed.addAll(it)
            }
    }
}