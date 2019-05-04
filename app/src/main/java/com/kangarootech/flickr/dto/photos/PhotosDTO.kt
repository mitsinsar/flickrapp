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


data class PhotosDTO(
        val page: Int,
        val pages: Int,
        @SerializedName("perpage")
        val perPage: Int,
        val total: Int,
        @SerializedName("photo")
        val photoList: List<PhotoDTO>)