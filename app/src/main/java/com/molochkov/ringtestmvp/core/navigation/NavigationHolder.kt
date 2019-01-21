package com.molochkov.ringtestmvp.core.navigation

import androidx.fragment.app.Fragment

/**
 * application navigation holder
 */
interface NavigationHolder {

    /**
     * shows selected fragment
     * @param fragment to show
     * @param addToBackStack is fragment should be added to back stack
     */
    fun showFragment(fragment: Fragment, addToBackStack: Boolean = true)
}