package com.molochkov.ringtestmvp.core.base

/**
 * parent presenter for all presenters in project
 */
abstract class BasePresenter<T : BaseView> {

    protected var mvpView: T? = null

    open fun onAttachView(mvpView: T) {
        this.mvpView = mvpView
    }

    open fun onDetachView() {
        this.mvpView = null
    }
}