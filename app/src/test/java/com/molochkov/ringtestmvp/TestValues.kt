package com.molochkov.ringtestmvp

import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.utils.Workers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

const val IMAGE_URL = "https://24smi.org/public/media/235x307/celebrity/2017/02/15/UjKaLUES5LHY_gomer.jpg"
val workers = Workers(Schedulers.trampoline(), Schedulers.trampoline())
val feedEntry = FeedEntry("author",
    IMAGE_URL,
    1548062619749L,
    "some title",
    IMAGE_URL,
    42)
val feed = listOf(feedEntry, feedEntry, feedEntry)

class TestNetworkException : HttpException(Response.error<Any>(500,
    ResponseBody.create(MediaType.parse("text/plain"), "Test Server Error")))