package com.kangarootech.flickr.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.R
import com.kangarootech.flickr.dto.photos.PhotoDTO
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
        val imageUrl = "https://farm${model.farm}.staticflickr.com/${model.server}/${model.id}_${model.secret}_z.jpg"
        Picasso.get().load(imageUrl).into(image)

        //TODO onItemClick
    }
}

//Image Url
//https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg

/*
Image Size Suffixes
s	small square 75x75
q	large square 150x150
t	thumbnail, 100 on longest side
m	small, 240 on longest side
n	small, 320 on longest side
-	medium, 500 on longest side
z	medium 640, 640 on longest side
c	medium 800, 800 on longest side† <- in use
b	large, 1024 on longest side*
h	large 1600, 1600 on longest side†
k	large 2048, 2048 on longest side†
o	original image, either a jpg, gif or png, depending on source format
 */