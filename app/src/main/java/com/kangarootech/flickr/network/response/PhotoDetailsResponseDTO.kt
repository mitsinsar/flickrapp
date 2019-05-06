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
)