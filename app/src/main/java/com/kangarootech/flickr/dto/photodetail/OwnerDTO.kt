package com.kangarootech.flickr.dto.photodetail

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


data class OwnerDTO(
    val nsid: String,
    val username: String,
    val realname: String,
    val location: String,
    @SerializedName("iconserver")
    val iconServer: String,
    @SerializedName("iconfarm")
    val iconFarm: Int,
    val path_alias: String?
)