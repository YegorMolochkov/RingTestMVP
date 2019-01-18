package com.molochkov.ringtestmvp.core.base

import androidx.fragment.app.Fragment
import com.molochkov.ringtestmvp.screens.main.ui.MainActivity
import com.molochkov.ringtestmvp.utils.LoadingDialog

abstract class BaseFragment : Fragment() {

    private lateinit var loadingDialog: LoadingDialog

    val mainActivity: MainActivity
        get() {
            return activity as MainActivity
        }

    open fun showLoading() {
        if (!::loadingDialog.isInitialized) loadingDialog = LoadingDialog.newInstance()
        if (!loadingDialog.isAdded) {
            loadingDialog.show(fragmentManager, LoadingDialog::class.java.simpleName)
        }
    }

    open fun hideLoading() {
        if (::loadingDialog.isInitialized) loadingDialog.dismiss()
    }
}