package com.kangarootech.flickr.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.R
import com.kangarootech.flickr.datalayer.network.dto.photos.PhotoDTO
import com.squareup.picasso.Picasso

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class RecentImagesViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.adapter_item_recent_images, parent, false)
) {

    init {
        val height = parent.measuredWidth / 2
        itemView.layoutParams.height = height
    }

    private val image by lazy { itemView.findViewById<ImageView>(R.id.imgRecentImages) }
    private val title by lazy { itemView.findViewById<TextView>(R.id.txtRecentImageTitle) }

    fun bind(model: PhotoDTO, onItemClick: (PhotoDTO) -> Unit) {

        title.text = model.title
        Picasso.get().load(model.getImageUrl()).into(image)

        itemView.setOnClickListener {
            onItemClick(model)
        }
    }
}