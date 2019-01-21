package com.molochkov.ringtestmvp.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class ActivityNavigationHolder(private val manager: FragmentManager,
                               private val containerId: Int) : NavigationHolder {

    override fun showFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = manager.beginTransaction().apply {
            replace(containerId, fragment)
            if (addToBackStack) addToBackStack(fragment::class.java.simpleName)
        }
        transaction.commit()
    }
}