package com.kangarootech.flickr.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.PicassoHelper
import com.kangarootech.flickr.dto.photos.PhotoDTO
import com.kangarootech.flickr.viewholder.RecentImagesViewHolder

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class RecentImagesRecyclerAdapter(
    private var items: MutableList<PhotoDTO>,
    private val mPicassoHelper: PicassoHelper,
    private val onItemClick: (PhotoDTO) -> Unit
) : RecyclerView.Adapter<RecentImagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecentImagesViewHolder(parent, mPicassoHelper)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecentImagesViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    fun updateList(list: List<PhotoDTO>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    fun appendToList(list: List<PhotoDTO>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}