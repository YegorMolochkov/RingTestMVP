package com.molochkov.ringtestmvp.screens.feed.data

import com.molochkov.ringtestmvp.data.feed.FeedEntryDto
import java.util.concurrent.TimeUnit

private const val IMAGE_EXTENSION = ".jpg"

data class FeedEntry(val author: String,
                     val thumbnail: String?,
                     val created: Long,
                     val title: String,
                     val imageUrl: String?,
                     val comments: Int)

fun FeedEntryDto.toFeedEntry(): FeedEntry = with(this) {
    return@with FeedEntry(author,
        if (thumbnail.endsWith(IMAGE_EXTENSION)) thumbnail else null,
        TimeUnit.SECONDS.toMillis(created),
        title,
        if (url.endsWith(IMAGE_EXTENSION)) url else null,
        comments)
}