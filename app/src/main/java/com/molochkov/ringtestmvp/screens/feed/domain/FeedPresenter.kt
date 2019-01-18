package com.molochkov.ringtestmvp.screens.feed.domain

import android.widget.ImageView
import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.feed.navigation.FeedRouter
import com.molochkov.ringtestmvp.screens.feed.ui.FeedView

class FeedPresenter(private val interactor: FeedInteractor,
                    private val router: FeedRouter) : BasePresenter<FeedView>() {

    fun doOnStart() {
        interactor.getFeed({
            this.mvpView?.onFeedLoaded(it)
        }, {
            this.mvpView?.onLoadError()
        })
    }

    fun loadMore() {
        mvpView?.showLoading()
        interactor.loadMoreFeed({
            mvpView?.hideLoading()
            mvpView?.onFeedLoaded(it)
        }, {
            mvpView?.hideLoading()
            mvpView?.onLoadError()
        })
    }


    fun showImage(view: ImageView, imageUrl: String) = router.showImage(view, imageUrl)

    override fun onDetachView() {
        super.onDetachView()
        mvpView?.hideLoading()
        interactor.unsubscribe()
    }
}