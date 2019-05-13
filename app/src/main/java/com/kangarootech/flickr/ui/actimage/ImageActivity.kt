package com.kangarootech.flickr.ui.actimage

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.kangarootech.flickr.R
import com.kangarootech.flickr.datalayer.Repository
import com.kangarootech.flickr.datalayer.network.PicassoClient
import com.kangarootech.flickr.datalayer.network.dto.photodetail.PhotoDetailDTO
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.layout_image_activity_bottom.*
import kotlinx.android.synthetic.main.layout_image_activity_top.*

class ImageActivity : AppCompatActivity(), ImageActivityContract.View, OnClickListener {

    private val mPresenter by lazy { ImageActivityPresenter(this, Repository(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        intent?.run {
            val photoId = getStringExtra("photoId")
            mPresenter.getImageDetailsById(photoId)
        }

        btnImageActClose.setOnClickListener(this)
        btnImageActComment.setOnClickListener(this)
        btnImageActShare.setOnClickListener(this)
        btnImageActInfo.setOnClickListener(this)
        btnImageActFavorite.setOnClickListener(this)
        imgImageActivityOwnerImage.setOnClickListener(this)
        txtImageActivityOwnerName.setOnClickListener(this)
        imgImageActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnImageActClose.id -> finish()
            imgImageActivity.id -> {
                mPresenter.onClickImage()
            }
        }
    }

    override fun hideProgress() {
        pbarImageActLoading.visibility = View.INVISIBLE
    }

    override fun showProgress() {
        pbarImageActLoading.visibility = View.VISIBLE
    }

    override fun updateImageInfo(model: PhotoDetailDTO) {
        txtImageActivityOwnerName.text = model.owner.username
        txtImageActImageTitle.text = model.title._content.toString()
        val commentPlaceholder = "${model.comments._content} Comments"
        txtImageActCommentCount.text = commentPlaceholder
        val viewPlaceholder = "${model.views} Views"
        txtImageActViewCount.text = viewPlaceholder

    }

    override fun setInfoBarsVisibility() {
        if (layoutImgActivityTop.isVisible || layoutImgActivityBottom.isVisible) {
            layoutImgActivityBottom.visibility = View.GONE
            layoutImgActivityTop.visibility = View.GONE
        } else {
            layoutImgActivityBottom.visibility = View.VISIBLE
            layoutImgActivityTop.visibility = View.VISIBLE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun loadImage(imageUrl: String) {
        PicassoClient.getClient().load(imageUrl).into(object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                imgImageActivity.setImageBitmap(bitmap!!)
            }

        })
    }

    override fun loadOwnerIcon(iconUrl: String) {
        PicassoClient.getClient().load(iconUrl).into(imgImageActivityOwnerImage)
    }
}
