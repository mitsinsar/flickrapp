package com.kangarootech.flickr

import android.widget.ImageView
import com.squareup.picasso.Picasso

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
        mPicassoInstance.load(url).into(targetView)
    }

    override fun loadUrlFitCenterInside(url: String, targetView: ImageView) {
        mPicassoInstance.load(url).fit().centerInside().into(targetView)
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