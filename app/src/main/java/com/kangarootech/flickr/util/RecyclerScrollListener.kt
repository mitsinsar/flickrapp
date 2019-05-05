package com.kangarootech.flickr.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

///////////////////////
// Mithat Sinan Sarı //
//-------------------//
//     3.05.2019    //
//-------------------//
//       ʕ•ᴥ•ʔ        //
///////////////////////
abstract class RecyclerScrollListener(private val layoutManager: GridLayoutManager)
    : RecyclerView.OnScrollListener() {

    private val pageSize = 100
    abstract var isLoading: Boolean
    abstract var isLastPage: Boolean
    abstract fun loadMoreItems()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemCount = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading) {
            if ((visibleItemCount + firstVisibleItemCount) >= totalItemCount
                    && firstVisibleItemCount >= 0
                    && totalItemCount >= pageSize)
                loadMoreItems()
        }

    }

}