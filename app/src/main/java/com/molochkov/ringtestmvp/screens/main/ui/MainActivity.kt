package com.molochkov.ringtestmvp.screens.main.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.RingApplication
import com.molochkov.ringtestmvp.screens.main.di.DaggerMainActivityComponent
import com.molochkov.ringtestmvp.screens.main.di.MainActivityComponent
import com.molochkov.ringtestmvp.screens.main.di.MainActivityModule
import com.molochkov.ringtestmvp.screens.main.domain.MainPresenter
import javax.inject.Inject

class MainActivity : FragmentActivity(), MainView {

    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .applicationComponent((application as RingApplication).appComponent)
            .build()
    }

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        presenter.onAttachView(this)
        if (savedInstanceState == null) {
            presenter.showStartScreen()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetachView()
    }
}