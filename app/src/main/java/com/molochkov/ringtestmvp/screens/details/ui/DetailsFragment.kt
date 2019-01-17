package com.molochkov.ringtestmvp.screens.details.ui

import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.base.BaseFragment
import com.molochkov.ringtestmvp.screens.details.di.DaggerDetailsComponent
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    companion object {

        private const val IMAGE_URL_KEY = "IMAGE_URL_KEY"
        private const val CODE_STORAGE = 1

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
        initViews()
    }

    private fun initViews() {
        photoLoader.loadPhoto(imageUrl, imageView)
        saveBtn.setOnClickListener { requestPermission() }
    }

    private fun requestPermission() {
        getPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, CODE_STORAGE)
    }

    private fun getPermission(permission: String, requestCode: Int) {
        if (hasPermission(permission)) onPermissionGranted(permission)
        else requestPermissions(arrayOf(permission), requestCode)
    }

    private fun hasPermission(permission: String): Boolean =
        ActivityCompat.checkSelfPermission(mainActivity, permission) ==
                PackageManager.PERMISSION_GRANTED

    private fun onPermissionGranted(permission: String) {
        if (permission == android.Manifest.permission.WRITE_EXTERNAL_STORAGE) {
            saveImage()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onPermissionGranted(permissions[0])
        }
    }

    private fun saveImage() {
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val newUrl = MediaStore.Images.Media.insertImage(mainActivity.baseContext.contentResolver,
            bitmap, imageUrl, imageUrl)
        val toastTextId = if (newUrl == null) R.string.save_fail else R.string.save_success
        Toast.makeText(mainActivity, toastTextId, Toast.LENGTH_LONG).show()
    }
}