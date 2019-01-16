package com.molochkov.ringtestmvp.core.base

abstract class BasePresenter<T : BaseView> {

    protected var mvpView: T? = null

    open fun onAttachView(mvpView: T) {
        this.mvpView = mvpView
    }

    open fun onDetachView() {
        this.mvpView = null
    }
}