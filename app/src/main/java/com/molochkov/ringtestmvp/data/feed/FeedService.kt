package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit feed service
 */
interface FeedService {

    /**
     * loads new feed page
     * @param limit page size
     * @param lastId id of last, previously loaded, entry
     * @return new feed page
     */
    @GET("/top.json")
    fun getFeed(@Query("limit") limit: Int,
                @Query("after") lastId: String?): Single<FeedResponse>
}