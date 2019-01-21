package com.molochkov.ringtestmvp.screens.feed.domain

import com.molochkov.ringtestmvp.RANDOM_TEXT
import com.molochkov.ringtestmvp.TestNetworkException
import com.molochkov.ringtestmvp.feed
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.navigation.FeedRouter
import com.molochkov.ringtestmvp.screens.feed.ui.FeedView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`

@Suppress("UNCHECKED_CAST")
class FeedPresenterTests {

    private val view: FeedView = mock()
    private val router: FeedRouter = mock()
    private val interactor: FeedInteractor = mock()
    private val presenter = FeedPresenter(interactor, router)

    @Before
    fun before() {
        presenter.onAttachView(view)
    }

    @After
    fun after() {
        presenter.onDetachView()
    }

    @Test
    fun doOnStartSuccess() {
        `when`(interactor.getFeed(any(), any())).then {
            (it.arguments[0] as (List<FeedEntry>) -> Unit).invoke(feed)
        }

        presenter.doOnStart()

        verify(view).onFeedLoaded(feed)
        verify(view, never()).onLoadError()
    }

    @Test
    fun doOnStartFail() {
        `when`(interactor.getFeed(any(), any())).then {
            (it.arguments[1] as (Throwable) -> Unit).invoke(TestNetworkException())
        }

        presenter.doOnStart()

        verify(view, never()).onFeedLoaded(any())
        verify(view).onLoadError()
    }

    @Test
    fun loadMoreSuccess() {
        `when`(interactor.loadMoreFeed(any(), any())).then {
            (it.arguments[0] as (List<FeedEntry>) -> Unit).invoke(feed)
        }

        presenter.loadMore()

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).onFeedLoaded(feed)
        verify(view, never()).onLoadError()
    }

    @Test
    fun loadMoreFail() {
        `when`(interactor.loadMoreFeed(any(), any())).then {
            (it.arguments[1] as (Throwable) -> Unit).invoke(TestNetworkException())
        }

        presenter.loadMore()

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view, never()).onFeedLoaded(any())
        verify(view).onLoadError()
    }

    @Test
    fun showImage() {
        presenter.showImage(RANDOM_TEXT)
        verify(router).showImage(RANDOM_TEXT)
    }
}