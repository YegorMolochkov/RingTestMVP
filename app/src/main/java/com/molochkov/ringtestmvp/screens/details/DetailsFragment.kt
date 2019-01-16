package com.molochkov.ringtestmvp.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.base.BaseFragment
import com.molochkov.ringtestmvp.screens.details.di.DaggerDetailsComponent
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    companion object {

        private const val IMAGE_URL_KEY = "IMAGE_URL_KEY"

        fun newInstance(imageUrl: String): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = Bundle().apply {
                putString(IMAGE_URL_KEY, imageUrl)
            }
            return fragment
        }
    }

    private val component by lazy {
        DaggerDetailsComponent.builder()
            .mainActivityComponent(mainActivity.activityComponent)
            .build()
    }
    @Inject
    lateinit var photoLoader: PhotoLoader
    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        arguments?.getString(IMAGE_URL_KEY)?.let { imageUrl = it }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoLoader.loadPhoto(imageUrl, imageView)
    }
}