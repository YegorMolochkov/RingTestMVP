package com.molochkov.ringtestmvp.screens.feed.data

import com.molochkov.ringtestmvp.data.feed.FeedEntryDto

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
        created,
        title,
        if (url.endsWith(IMAGE_EXTENSION)) url else null,
        comments)
}