package com.molochkov.ringtestmvp.core.navigation

import android.view.View
import androidx.fragment.app.Fragment

interface NavigationHolder {

    fun showFragment(fragment: Fragment, addToBackStack: Boolean = true)

    fun showFragmentWithSharedView(fragment: Fragment, sharedView: View, transitionName: String)
}