package com.molochkov.ringtestmvp.screens.feed.data

import com.molochkov.ringtestmvp.data.feed.FeedEntryDto

data class FeedEntry(val author: String,
                     val thumbnail: String?,
                     val created: Long,
                     val title: String,
                     val comments: Int)

fun FeedEntryDto.toFeedEntry(): FeedEntry = with(this) {
    return@with FeedEntry(author,
        if (thumbnail.endsWith(".jpg")) thumbnail else null,
        created,
        title,
        comments)
}