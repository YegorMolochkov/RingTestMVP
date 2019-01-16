package com.molochkov.ringtestmvp.core.base

import io.reactivex.disposables.CompositeDisposable


abstract class BaseInteractor {

    protected val disposables = CompositeDisposable()

    open fun unsubscribe() = disposables.clear()
}
