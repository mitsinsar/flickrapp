package com.kangarootech.flickr.dto.photos

import com.google.gson.annotations.SerializedName

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        4.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class PhotoDTO(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    @SerializedName("ispublic")
    val isPublic: Int,
    @SerializedName("isfriend")
    val isFriend: Int,
    @SerializedName("isfamily")
    val isFamily: Int
)