package com.kangarootech.flickr.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.PicassoHelper
import com.kangarootech.flickr.dto.photos.PhotoDTO
import com.kangarootech.flickr.viewholder.SearchViewHolder

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        6.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class SearchRecyclerAdapter(private var items: List<PhotoDTO>,
                            private val mPicassoHelper: PicassoHelper,
                            private val onItemClick:(PhotoDTO) -> Unit)
    :RecyclerView.Adapter<SearchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(parent, mPicassoHelper)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    fun updateList(list: List<PhotoDTO>){
        items = list
        notifyDataSetChanged()
    }
}