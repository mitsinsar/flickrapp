package com.kangarootech.flickr.ui.actimage

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.kangarootech.flickr.R
import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.dto.photodetail.PhotoDetailDTO
import com.squareup.picasso.Picasso
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
                if (layoutImgActivityTop.isVisible || layoutImgActivityBottom.isVisible) {
                    layoutImgActivityBottom.visibility = View.GONE
                    layoutImgActivityTop.visibility = View.GONE
                } else {
                    layoutImgActivityBottom.visibility = View.VISIBLE
                    layoutImgActivityTop.visibility = View.VISIBLE
                }
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

        loadImage(model.farm, model.server, model.id, model.originalSecret, model.secret, model.originalFormat)
        loadOwnerIcon(model.owner.iconFarm, model.owner.iconServer, model.owner.nsid)

        txtImageActivityOwnerName.text = model.owner.username
        txtImageActImageTitle.text = model.title._content.toString()
        val commentPlaceholder = "${model.comments._content} Comments"
        txtImageActCommentCount.text = commentPlaceholder
        val viewPlaceholder = "${model.views} Views"
        txtImageActViewCount.text = viewPlaceholder

    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun loadImage(farm: Int, server: String, id: String, secret: String, o_secret: String?, format: String?) {

        val imageUrl = if (o_secret != null) {
            "https://farm$farm.staticflickr.com/$server/${id}_$o_secret.$format"
        } else {
            "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
        }

        Picasso.get()
            .load(imageUrl)
            .into(imgImageActivity)
    }

    private fun loadOwnerIcon(farm: Int, server: String, nsid: String) {

        val iconUrl = "http://farm$farm.staticflickr.com/$server/buddyicons/$nsid.jpg"

        Picasso.get()
            .load(iconUrl)
            .placeholder(R.drawable.dr_placeholder_profilepic)
            .into(imgImageActivityOwnerImage)
    }
}
