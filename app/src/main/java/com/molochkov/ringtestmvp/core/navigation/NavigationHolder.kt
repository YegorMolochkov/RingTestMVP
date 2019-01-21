package com.molochkov.ringtestmvp.core.navigation

import androidx.fragment.app.Fragment

interface NavigationHolder {

    fun showFragment(fragment: Fragment, addToBackStack: Boolean = true)
}