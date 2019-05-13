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


data class DatesDTO(
    val posted: String,
    val taken: String,
    @SerializedName("takengranularity")
    val takenGranularity: Any,
    @SerializedName("takenunknown")
    val takenUnknown: String,
    @SerializedName("lastupdate")
    val lastUpdate: String
)