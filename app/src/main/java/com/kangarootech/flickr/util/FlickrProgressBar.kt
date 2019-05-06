package com.kangarootech.flickr.util

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.kangarootech.flickr.R

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        6.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class FlickrProgressBar(context: Context, attr: AttributeSet) : ImageView(context, attr) {

    private val animationDrawable: AnimationDrawable

    init {
        setBackgroundResource(R.drawable.gif_loading_flickr)
        animationDrawable = background as AnimationDrawable
    }

    fun showLoading() {
        visibility = View.VISIBLE
        animationDrawable.start()
    }

    fun hideLoading() {
        visibility = View.GONE
        animationDrawable.stop()
    }
}