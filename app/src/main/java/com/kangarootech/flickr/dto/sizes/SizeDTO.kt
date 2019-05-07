package com.kangarootech.flickr.dto.sizes

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


data class SizeDTO(
        val label: String,

        // these variables are set Any because server returns Int or String
        val width: Any,
        val height: Any,

        val source: String,
        val url: String,
        val media: String
)