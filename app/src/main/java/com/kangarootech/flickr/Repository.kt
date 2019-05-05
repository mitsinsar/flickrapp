package com.kangarootech.flickr

import android.content.Context
import com.kangarootech.flickr.enums.StatusCodeEnum
import com.kangarootech.flickr.network.ApiService
import com.kangarootech.flickr.network.RetrofitClient
import com.kangarootech.flickr.network.response.PhotosResponseDTO
import com.kangarootech.flickr.util.hasConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class Repository(private val context: Context) {

    fun getImages(page: Int, onResult: (PhotosResponseDTO?, resultCode: Int) -> Unit) {

        if (hasConnection(context)) {
            RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getRecentImages(page)
                .enqueue(object : Callback<PhotosResponseDTO?> {
                    override fun onFailure(call: Call<PhotosResponseDTO?>, t: Throwable) {
                        onResult(null, StatusCodeEnum.SERVICE_UNAVAILABLE.value)
                    }

                    override fun onResponse(call: Call<PhotosResponseDTO?>, response: Response<PhotosResponseDTO?>) {
                        if (response.body()?.photos != null) {
                            onResult(response.body(), StatusCodeEnum.OK.value)
                        } else {
                            onResult(null, StatusCodeEnum.NO_CONTENT.value)
                        }
                    }
                })
        } else {
            onResult(null, StatusCodeEnum.CONNECTION_ERROR.value)
        }
    }

}