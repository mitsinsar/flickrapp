package com.kangarootech.flickr.network.response

import com.kangarootech.flickr.dto.photodetail.PhotoDetailDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class PhotoDetailsResponseDTO(
    val photo: PhotoDetailDTO,
    val stat: String
) {
    fun getOwnerIconUrl() =
        "http://farm${photo.owner.iconFarm}.staticflickr.com/${photo.owner.iconServer}/buddyicons/${photo.owner.nsid}.jpg"

    fun getImageUrl() = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
}