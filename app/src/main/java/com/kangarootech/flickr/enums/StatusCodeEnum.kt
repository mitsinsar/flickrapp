package com.kangarootech.flickr.enums

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


enum class StatusCodeEnum(val value: Int) {
    OK(200),
    CONNECTION_ERROR(600),
    SERVICE_UNAVAILABLE(503),
    NO_CONTENT(204)
}