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


data class UsageDTO(
    @SerializedName("candownload")
    val canDownload: Int,
    @SerializedName("canblog")
    val canBlog: Int,
    @SerializedName("canprint")
    val canPrint: Int,
    @SerializedName("canshare")
    val canShare: Int
)