package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single

interface FeedRepository {

    fun getFeed(): Single<List<FeedEntry>>
}