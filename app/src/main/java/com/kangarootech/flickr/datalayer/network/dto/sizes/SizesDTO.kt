package com.kangarootech.flickr.datalayer.network.dto.sizes

import com.google.gson.annotations.SerializedName

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class SizesDTO (
        @SerializedName("canblog")
        val canBlog: Int,
        @SerializedName("canprint")
        val canPrint: Int,
        @SerializedName("candownload")
        val canDownload: Int,
        val size: List<SizeDTO>
)