package com.molochkov.ringtestmvp.screens.feed.ui

import com.molochkov.ringtestmvp.core.base.BaseView
import com.molochkov.ringtestmvp.data.feed.FeedEntry

interface FeedView : BaseView {

    fun onFeedLoaded(feed: List<FeedEntry>)

    fun onLoadError()
}