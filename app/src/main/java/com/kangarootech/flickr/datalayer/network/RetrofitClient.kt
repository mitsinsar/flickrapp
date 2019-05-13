package com.kangarootech.flickr.datalayer.network

import com.kangarootech.flickr.BuildConfig
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
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}