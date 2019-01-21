package com.molochkov.ringtestmvp

import com.molochkov.ringtestmvp.data.feed.FeedChild
import com.molochkov.ringtestmvp.data.feed.FeedData
import com.molochkov.ringtestmvp.data.feed.FeedEntryDto
import com.molochkov.ringtestmvp.data.feed.FeedResponse
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.data.toFeedEntry
import com.molochkov.ringtestmvp.utils.Workers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

const val RANDOM_TEXT = "RANDOM_TEXT"
const val TIME = 1548062619749L
const val RANDOM_NUMBER = 42
val workers = Workers(Schedulers.trampoline(), Schedulers.trampoline())
val feedEntryDto = FeedEntryDto(RANDOM_TEXT,
    RANDOM_TEXT,
    TIME,
    RANDOM_TEXT,
    RANDOM_TEXT,
    RANDOM_NUMBER)
val feedChild = FeedChild(RANDOM_TEXT, feedEntryDto)
val feedData = FeedData(RANDOM_TEXT, listOf(feedChild), RANDOM_TEXT, RANDOM_TEXT)
val feedResponse = FeedResponse(RANDOM_TEXT, feedData)
val feedDto = listOf(feedEntryDto)
val feed = feedDto.map { it.toFeedEntry() }

class TestNetworkException : HttpException(Response.error<Any>(500,
    ResponseBody.create(MediaType.parse("text/plain"), "Test Server Error")))