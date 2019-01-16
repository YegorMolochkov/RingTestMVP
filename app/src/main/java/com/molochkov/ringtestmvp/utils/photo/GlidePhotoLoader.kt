package com.molochkov.ringtestmvp.utils.photo

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlidePhotoLoader(val context: Context) : PhotoLoader {

    override fun loadPhoto(url: String?, view: ImageView) {
        Glide.with(context)
            .load(url)
            .into(view)
    }
}