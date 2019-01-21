package com.molochkov.ringtestmvp.screens.main.domain

import com.molochkov.ringtestmvp.screens.main.navigation.MainRouter
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class MainPresenterTests {

    private val router: MainRouter = mock()
    private val presenter = MainPresenter(router)

    @Test
    fun showStartScreen() {
        presenter.showStartScreen()
        verify(router).showStartScreen()
    }
}