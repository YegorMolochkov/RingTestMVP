package com.molochkov.ringtestmvp.screens.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.RingApplication
import com.molochkov.ringtestmvp.screens.feed.FeedFragment
import com.molochkov.ringtestmvp.screens.main.di.DaggerMainActivityComponent
import com.molochkov.ringtestmvp.screens.main.di.MainActivityComponent
import com.molochkov.ringtestmvp.screens.main.di.MainActivityModule

class MainActivity : FragmentActivity() {

    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .applicationComponent((application as RingApplication).appComponent)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, FeedFragment.newInstance())
            .commit()
    }
}