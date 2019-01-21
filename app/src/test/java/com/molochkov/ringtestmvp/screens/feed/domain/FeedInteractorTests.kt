package com.molochkov.ringtestmvp.screens.feed.domain

import com.molochkov.ringtestmvp.TestNetworkException
import com.molochkov.ringtestmvp.data.feed.FeedRepository
import com.molochkov.ringtestmvp.feed
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.workers
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`

class FeedInteractorTests {

    private val repository: FeedRepository = mock()
    private val interactor = FeedInteractor(repository, workers)

    @Test
    fun getFeedSuccess() {
        `when`(repository.getFeed()).thenReturn(Single.just(feed))

        var result: List<FeedEntry>? = null
        var error: Throwable? = null

        interactor.getFeed({ result = it }, { error = it })
        Assert.assertNull(error)
        Assert.assertEquals(feed, result)
    }

    @Test
    fun getFeedFail() {
        `when`(repository.getFeed()).thenReturn(Single.error(TestNetworkException()))

        var result: List<FeedEntry>? = null
        var error: Throwable? = null

        interactor.getFeed({ result = it }, { error = it })
        Assert.assertNull(result)
        Assert.assertTrue(error is TestNetworkException)
    }

    @Test
    fun loadMoreFeedSuccess() {
        `when`(repository.loadMoreFeed()).thenReturn(Single.just(feed))

        var result: List<FeedEntry>? = null
        var error: Throwable? = null

        interactor.loadMoreFeed({ result = it }, { error = it })
        Assert.assertNull(error)
        Assert.assertEquals(feed, result)
    }

    @Test
    fun loadMoreFeedFail() {
        `when`(repository.loadMoreFeed()).thenReturn(Single.error(TestNetworkException()))

        var result: List<FeedEntry>? = null
        var error: Throwable? = null

        interactor.loadMoreFeed({ result = it }, { error = it })
        Assert.assertNull(result)
        Assert.assertTrue(error is TestNetworkException)
    }
}