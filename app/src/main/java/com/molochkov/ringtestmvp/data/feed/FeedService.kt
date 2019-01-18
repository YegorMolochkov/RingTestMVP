package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedService {

    @GET("/top.json")
    fun getFeed(@Query("limit") limit: Int,
                @Query("after") lastId: String?): Single<FeedResponse>
}