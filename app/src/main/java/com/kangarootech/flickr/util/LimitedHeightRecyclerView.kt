package com.kangarootech.flickr.util

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.R

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class LimitedHeightRecyclerView(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    private val maxItemCount: Int
    private val DEFAULT_ITEM_COUNT = 4

    init {
        val arr = context.obtainStyledAttributes(attrs, R.styleable.LimitedHeightRecyclerView)
        val tempItemCount = arr.getInteger(R.styleable.LimitedHeightRecyclerView_maxItemCount, DEFAULT_ITEM_COUNT)
        maxItemCount = if (tempItemCount > 0) tempItemCount else DEFAULT_ITEM_COUNT
        arr.recycle()
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val height = MeasureSpec.makeMeasureSpec(dpsToPx(context, maxItemCount * 40f).toInt(), MeasureSpec.AT_MOST)
        super.onMeasure(widthSpec, height)
    }

    private fun dpsToPx(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }
}