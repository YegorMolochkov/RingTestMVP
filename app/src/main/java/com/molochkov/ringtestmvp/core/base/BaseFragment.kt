package com.molochkov.ringtestmvp.core.base

import androidx.fragment.app.Fragment
import com.molochkov.ringtestmvp.screens.main.MainActivity

abstract class BaseFragment : Fragment() {

    val mainActivity: MainActivity
        get() {
            return activity as MainActivity
        }
}