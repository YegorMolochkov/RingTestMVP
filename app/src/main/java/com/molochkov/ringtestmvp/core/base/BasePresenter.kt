package com.molochkov.ringtestmvp.core.base

abstract class BasePresenter<T : BaseView>(private val interactor: BaseInteractor) {

    protected var mvpView: T? = null

    open fun onAttachView(mvpView: T) {
        this.mvpView = mvpView
    }

    open fun onDetachView() {
        this.mvpView = null
        interactor.unsubscribe()
    }
}