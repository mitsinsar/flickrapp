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


data class PhotoDetailDTO(
    val id: String,
    val secret: String,
    val server: String,
    val farm: Int,
    @SerializedName("dateuploaded")
    val dateUploaded: String,
    @SerializedName("isfavorite")
    val isFavorite: Int,
    val license: String,
    val safety_level: String,
    val rotation: Int,
    @SerializedName("originalsecret")
    val originalSecret: String,
    @SerializedName("originalformat")
    val originalFormat: String,
    val owner: OwnerDTO,
    val title: ContentDTO,
    val description: ContentDTO,
    val visibility: VisibilityDTO,
    val dates: DatesDTO,
    val views: String,
    val editability: EditabilityDTO,
    @SerializedName("publiceditability")
    val publicEditability: EditabilityDTO,
    val usage: UsageDTO,
    val comments: ContentDTO,
    val note: Any,
    val people: PeopleDTO,
    val tags: Any,
    val urls: Any,
    val media: String
)