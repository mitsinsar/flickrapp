package com.kangarootech.flickr.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        4.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class RetrofitClient {
    companion object {

        @JvmStatic
        fun getClient(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(ApiEnum.API_BASE_URL.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}