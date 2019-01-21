package com.molochkov.ringtestmvp.core.base

import androidx.fragment.app.Fragment
import com.molochkov.ringtestmvp.screens.main.ui.MainActivity
import com.molochkov.ringtestmvp.utils.LoadingDialog

/**
 * parent fragment for all fragments in project
 */
abstract class BaseFragment : Fragment() {

    private lateinit var loadingDialog: LoadingDialog

    val mainActivity: MainActivity
        get() {
            return activity as MainActivity
        }

    /**
     * shows loading dialog
     */
    open fun showLoading() {
        if (!::loadingDialog.isInitialized) loadingDialog = LoadingDialog.newInstance()
        if (!loadingDialog.isAdded) {
            loadingDialog.show(fragmentManager, LoadingDialog::class.java.simpleName)
        }
    }

    /**
     * hides loading dialog
     */
    open fun hideLoading() {
        if (::loadingDialog.isInitialized) loadingDialog.dismiss()
    }
}