package com.molochkov.ringtestmvp.data.feed

import com.molochkov.ringtestmvp.TestNetworkException
import com.molochkov.ringtestmvp.feed
import com.molochkov.ringtestmvp.feedResponse
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito.`when`

class FeedRepositoryTests {

    private companion object {
        const val PAGE_SIZE = 10
    }

    private val service: FeedService = mock()
    private val repository = RedditFeedRepository(service)

    @Test
    fun loadFeed() {
        `when`(service.getFeed(PAGE_SIZE, null)).thenReturn(Single.just(feedResponse))
        repository.getFeed().test().assertValue { it.isEmpty() }
        repository.loadMoreFeed().test()
        repository.getFeed().test().assertValue { !it.isEmpty() }
    }

    @Test
    fun loadMoreFeedSuccess() {
        `when`(service.getFeed(PAGE_SIZE, null)).thenReturn(Single.just(feedResponse))
        val call = repository.loadMoreFeed().test()
        call.assertNoErrors()
            .assertResult(feed)
    }

    @Test
    fun loadMoreFeedFail() {
        `when`(service.getFeed(PAGE_SIZE, null))
            .thenReturn(Single.error(TestNetworkException()))
        val call = repository.loadMoreFeed().test()
        call.assertError(TestNetworkException::class.java)
    }
}