package com.molochkov.ringtestmvp.utils.photo

import android.widget.ImageView

/**
 * photo loading util
 */
interface PhotoLoader {

    /**
     * downloads photo into view
     * @param url photo url
     * @param view view to display image
     */
    fun loadPhoto(url: String?, view: ImageView)
}