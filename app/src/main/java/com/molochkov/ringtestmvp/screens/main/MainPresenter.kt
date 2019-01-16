package com.molochkov.ringtestmvp.screens.main

import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.main.domain.MainInteractor
import com.molochkov.ringtestmvp.screens.main.navigation.MainRouter

class MainPresenter(private val interactor: MainInteractor,
                    private val router: MainRouter) : BasePresenter<MainView>(interactor) {

    fun showStartScreen() = router.showStartScreen()
}