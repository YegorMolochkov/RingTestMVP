package com.molochkov.ringtestmvp.data.feed

import com.google.gson.annotations.SerializedName

data class FeedResponse(val kind: String,
                        val data: FeedData)

data class FeedData(@SerializedName("modhash") val hash: String,
                    val children: List<FeedChild>)

data class FeedChild(val kind: String,
                     val data: FeedEntryDto)

data class FeedEntryDto(val author: String,
                        val thumbnail: String,
                        val created: Long,
                        val title: String,
                        @SerializedName("num_comments") val comments: Int)