package com.kangarootech.flickr.datalayer.network.dto.photodetail

import com.google.gson.annotations.SerializedName

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class EditabilityDTO(
    @SerializedName("cancomment")
    val canComment: Int,
    @SerializedName("canaddmeta")
    val canAddMeta: Int
)