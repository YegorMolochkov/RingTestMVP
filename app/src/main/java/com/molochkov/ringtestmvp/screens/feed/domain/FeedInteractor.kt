package com.molochkov.ringtestmvp.screens.feed.domain

import com.molochkov.ringtestmvp.core.base.BaseInteractor
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.data.toFeedEntry
import com.molochkov.ringtestmvp.utils.Workers

class FeedInteractor(private val repository: FeedRepository,
                     private val workers: Workers) : BaseInteractor() {

    private var lastId: String? = null

    fun getFeed(onDone: (List<FeedEntry>) -> Unit,
                onError: (Throwable) -> Unit) {
        disposables.add(repository.getFeed(lastId)
            .doOnSuccess {
                lastId = it.data.after
            }.map { response ->
                response.data.children.map { it.data.toFeedEntry() }
            }
            .subscribeOn(workers.subscribe)
            .observeOn(workers.observe)
            .subscribe(onDone, onError))
    }
}