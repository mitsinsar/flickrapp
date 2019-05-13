package com.kangarootech.flickr.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.R
import com.kangarootech.flickr.datalayer.network.PicassoClient
import com.kangarootech.flickr.datalayer.network.dto.photos.PhotoDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        6.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class SearchViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.adapter_item_search, parent, false)
) {

    private val image by lazy { itemView.findViewById<ImageView>(R.id.imgSearch) }

    fun bind(model: PhotoDTO, onItemClick: (PhotoDTO) -> Unit) {
        PicassoClient.getClient().load(model.getImageUrl()).into(image)

        itemView.setOnClickListener {
            onItemClick(model)
        }
    }
}