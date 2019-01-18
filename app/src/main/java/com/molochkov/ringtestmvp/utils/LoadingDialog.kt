package com.molochkov.ringtestmvp.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.molochkov.ringtestmvp.R

class LoadingDialog : DialogFragment() {

    private lateinit var progressBar: ProgressBar

    companion object {

        fun newInstance() = LoadingDialog()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_loading, container)
        progressBar = view.findViewById(R.id.progressBar)
        customizeUi()
        return view
    }

    private fun customizeUi() {
        context?.let {
            val color = ContextCompat.getColor(it, R.color.colorPrimaryDark)
            progressBar.indeterminateDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY)
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
    }
}