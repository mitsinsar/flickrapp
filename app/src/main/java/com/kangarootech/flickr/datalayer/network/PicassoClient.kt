package com.kangarootech.flickr.datalayer.network

import com.squareup.picasso.Picasso

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        13.05.2019      //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class PicassoClient {
    companion object {
        fun getClient() = Picasso.get()
    }
}