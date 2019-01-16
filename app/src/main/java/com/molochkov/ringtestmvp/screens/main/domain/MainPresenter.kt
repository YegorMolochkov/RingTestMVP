package com.molochkov.ringtestmvp.screens.main.domain

import com.molochkov.ringtestmvp.core.base.BasePresenter
import com.molochkov.ringtestmvp.screens.main.ui.MainView
import com.molochkov.ringtestmvp.screens.main.navigation.MainRouter

class MainPresenter(private val router: MainRouter) : BasePresenter<MainView>() {

    fun showStartScreen() = router.showStartScreen()
}