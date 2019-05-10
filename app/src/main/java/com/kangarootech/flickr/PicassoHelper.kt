package com.kangarootech.flickr

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        9.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class PicassoHelper : IImageHelper {

    private val mPicassoInstance by lazy { Picasso.get() }

    override fun loadUrl(url: String, targetView: ImageView) {
        mPicassoInstance.load(url).into(object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                targetView.setImageBitmap(bitmap!!)
            }

        })
    }

    override fun loadUrlWithPlaceholder(url: String, targetView: ImageView, placeholderSrc: Int) {
        mPicassoInstance.load(url).placeholder(placeholderSrc).into(targetView)
    }

    override fun loadUrlWithErrorImg(url: String, targetView: ImageView, errorImgSrc: Int) {
        mPicassoInstance.load(url).error(errorImgSrc).into(targetView)
    }

    override fun loadUrlWithPlaceholderAndError(
        url: String,
        targetView: ImageView,
        placeholderSrc: Int,
        errorImgSrc: Int
    ) {
        mPicassoInstance.load(url).placeholder(placeholderSrc).error(errorImgSrc).into(targetView)
    }
}