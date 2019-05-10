package com.kangarootech.flickr

import android.widget.ImageView

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        9.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


interface IImageHelper {

    fun loadUrl(url: String, targetView: ImageView)

    fun loadUrlWithPlaceholder(url: String, targetView: ImageView, placeholderSrc: Int)

    fun loadUrlWithErrorImg(url: String, targetView: ImageView, errorImgSrc: Int)

    fun loadUrlWithPlaceholderAndError(url: String, targetView: ImageView, placeholderSrc: Int,  errorImgSrc: Int)
}