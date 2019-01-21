package com.molochkov.ringtestmvp.core.base

import io.reactivex.disposables.CompositeDisposable

/**
 * parent interactor for all interactors in project
 */
abstract class BaseInteractor {

    protected val disposables = CompositeDisposable()

    open fun unsubscribe() = disposables.clear()
}
