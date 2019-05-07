package com.kangarootech.flickr.network.response

import com.kangarootech.flickr.dto.sizes.SizesDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class ImageSizesResponseDTO (
        val sizes: SizesDTO,
        val stat: String
)