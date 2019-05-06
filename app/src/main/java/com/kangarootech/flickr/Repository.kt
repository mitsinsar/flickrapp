package com.kangarootech.flickr

import android.content.Context
import com.kangarootech.flickr.enums.StatusCodeEnum
import com.kangarootech.flickr.network.ApiService
import com.kangarootech.flickr.network.RetrofitClient
import com.kangarootech.flickr.network.response.PhotoDetailsResponseDTO
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

    fun getImageDetailById(photoId: String, onResult: (PhotoDetailsResponseDTO?, resultCode: Int) -> Unit) {
        if (hasConnection(context)) {
            RetrofitClient.getClient()
                    .create(ApiService::class.java)
                    .getImageDetail(photoId)
                    .enqueue(object : Callback<PhotoDetailsResponseDTO?> {
                        override fun onFailure(call: Call<PhotoDetailsResponseDTO?>, t: Throwable) {
                            onResult(null, StatusCodeEnum.SERVICE_UNAVAILABLE.value)
                        }

                        override fun onResponse(
                                call: Call<PhotoDetailsResponseDTO?>,
                                response: Response<PhotoDetailsResponseDTO?>
                        ) {
                            if (response.body()?.photo != null) {
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

    fun getImageBySearch(searchText: String, onResult: (PhotosResponseDTO?, resultCode: Int) -> Unit) {
        if (hasConnection(context)) {
            RetrofitClient.getClient()
                    .create(ApiService::class.java)
                    .getImageBySearch(searchText)
                    .enqueue(object : Callback<PhotosResponseDTO?> {
                        override fun onFailure(call: Call<PhotosResponseDTO?>, t: Throwable) {
                            onResult(null, StatusCodeEnum.SERVICE_UNAVAILABLE.value)
                        }

                        override fun onResponse(call: Call<PhotosResponseDTO?>, response: Response<PhotosResponseDTO?>) {
                            if (response.body()?.photos?.photoList!!.isNotEmpty()) {
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

    fun getExploreImages(onResult: (PhotosResponseDTO?, resultCode: Int) -> Unit){
        if (hasConnection(context)){
            RetrofitClient.getClient()
                    .create(ApiService::class.java)
                    .getExploreImages()
                    .enqueue(object: Callback<PhotosResponseDTO?>{
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