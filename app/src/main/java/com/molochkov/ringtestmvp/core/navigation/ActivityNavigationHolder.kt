package com.molochkov.ringtestmvp.core.navigation

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class ActivityNavigationHolder(private val manager: FragmentManager,
                               private val containerId: Int) : NavigationHolder {

    override fun showFragment(fragment: Fragment) {
        manager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    override fun showFragmentWithSharedView(fragment: Fragment,
                                            sharedView: View,
                                            transitionName: String) {
        manager.beginTransaction()
            .addSharedElement(sharedView, transitionName)
            .replace(containerId, fragment)
            .commit()
    }
}