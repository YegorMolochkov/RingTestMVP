package com.molochkov.ringtestmvp.screens.feed

import android.widget.ImageView
import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.feed.domain.FeedInteractor
import com.molochkov.ringtestmvp.screens.feed.navigation.FeedRouter

class FeedPresenter(private val interactor: FeedInteractor,
                    private val router: FeedRouter) : BasePresenter<FeedView>(interactor) {

    fun getFeed() = interactor.getFeed({
        mvpView?.onFeedLoaded(it)
    }, {
        mvpView?.onLoadError()
    })

    fun showImage(view: ImageView, imageUrl: String) = router.showImage(view, imageUrl)
}