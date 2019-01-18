package com.molochkov.ringtestmvp.screens.feed.domain

import android.widget.ImageView
import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.ui.FeedView
import com.molochkov.ringtestmvp.screens.feed.navigation.FeedRouter

class FeedPresenter(private val interactor: FeedInteractor,
                    private val router: FeedRouter) : BasePresenter<FeedView>() {

    override fun onAttachView(mvpView: FeedView) {
        super.onAttachView(mvpView)
        interactor.getFeed({
            this.mvpView?.onFeedLoaded(it)
        }, {
            this.mvpView?.onLoadError()
        })
    }

    fun loadMore() {
        mvpView?.showLoading()
        interactor.loadMoreFeed({
            mvpView?.onFeedLoaded(it)
            mvpView?.hideLoading()
        }, {
            mvpView?.hideLoading()
            mvpView?.onLoadError()
        })
    }


    fun showImage(view: ImageView, imageUrl: String) = router.showImage(view, imageUrl)

    override fun onDetachView() {
        super.onDetachView()
        interactor.unsubscribe()
    }
}