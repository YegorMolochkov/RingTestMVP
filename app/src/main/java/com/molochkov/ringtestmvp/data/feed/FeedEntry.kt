package com.molochkov.ringtestmvp.data.feed

data class FeedEntry(val title: String,
                     val author: String,
                     val date: Long,
                     val image: String?,
                     val commentsNumber: Int)