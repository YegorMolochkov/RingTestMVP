package com.molochkov.ringtestmvp.screens.feed.domain

import com.molochkov.ringtestmvp.core.base.BaseInteractor
import com.molochkov.ringtestmvp.data.feed.FeedEntry
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.utils.Workers

class FeedInteractor(private val repository: FeedRepository,
                     private val workers: Workers) : BaseInteractor() {

    fun getFeed(onDone: (List<FeedEntry>) -> Unit,
                onError: (Throwable) -> Unit) {
        disposables.add(repository.getFeed()
            .subscribeOn(workers.subscribe)
            .observeOn(workers.observe)
            .subscribe(onDone, onError))
    }
}