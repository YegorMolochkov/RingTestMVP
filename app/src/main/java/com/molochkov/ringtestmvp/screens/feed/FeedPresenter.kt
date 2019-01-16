package com.molochkov.ringtestmvp.screens.feed

import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.feed.domain.FeedInteractor

class FeedPresenter(private val interactor: FeedInteractor) : BasePresenter<FeedView>(interactor)