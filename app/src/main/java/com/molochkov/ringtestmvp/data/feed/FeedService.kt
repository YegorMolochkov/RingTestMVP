package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single
import retrofit2.http.GET

interface FeedService {

    @GET("/top.json")
    fun getFeed(): Single<FeedResponse>
}