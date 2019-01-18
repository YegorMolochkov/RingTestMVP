package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single

interface FeedRepository {

    fun getFeed(lastId: String?): Single<FeedResponse>
}