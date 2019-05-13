package com.kangarootech.flickr

import com.kangarootech.flickr.network.ApiService
import com.kangarootech.flickr.network.RetrofitClient
import com.kangarootech.flickr.network.response.PhotoDetailsResponseDTO
import com.kangarootech.flickr.network.response.PhotosResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        13.05.2019      //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


object SendRequest {

    inline fun getRecentImages(
            page: Int,
            crossinline onResponse: (Call<PhotosResponseDTO?>, Response<PhotosResponseDTO?>) -> Unit,
            crossinline onFailure: (Call<PhotosResponseDTO?>, Throwable) -> Unit
    ) {
        RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getRecentImages(page)
                .enqueue(object : Callback<PhotosResponseDTO?> {
                    override fun onFailure(call: Call<PhotosResponseDTO?>, t: Throwable) {
                        onFailure(call, t)
                    }

                    override fun onResponse(call: Call<PhotosResponseDTO?>, response: Response<PhotosResponseDTO?>) {
                        onResponse(call, response)
                    }
                })
    }

    inline fun getPhotoDetail(
            photoId: String,
            crossinline onResponse: (Call<PhotoDetailsResponseDTO?>, Response<PhotoDetailsResponseDTO?>) -> Unit,
            crossinline onFailure: (Call<PhotoDetailsResponseDTO?>, Throwable) -> Unit
    ) {
        RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getImageDetail(photoId)
                .enqueue(object : Callback<PhotoDetailsResponseDTO?> {
                    override fun onFailure(call: Call<PhotoDetailsResponseDTO?>, t: Throwable) {
                        onFailure(call, t)
                    }

                    override fun onResponse(call: Call<PhotoDetailsResponseDTO?>, response: Response<PhotoDetailsResponseDTO?>) {
                        onResponse(call, response)
                    }
                })
    }

    inline fun getExploreImages(
            categoryId: String,
            crossinline onResponse: (Call<PhotosResponseDTO?>, Response<PhotosResponseDTO?>) -> Unit,
            crossinline onFailure: (Call<PhotosResponseDTO?>, Throwable) -> Unit
    ) {
        RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getExploreImages(categoryId)
                .enqueue(object : Callback<PhotosResponseDTO?> {
                    override fun onFailure(call: Call<PhotosResponseDTO?>, t: Throwable) {
                        onFailure(call, t)
                    }

                    override fun onResponse(call: Call<PhotosResponseDTO?>, response: Response<PhotosResponseDTO?>) {
                        onResponse(call, response)
                    }

                })
    }

    inline fun getSearchImages(
            searchText: String,
            crossinline onResponse: (Call<PhotosResponseDTO?>, Response<PhotosResponseDTO?>) -> Unit,
            crossinline onFailure: (Call<PhotosResponseDTO?>, Throwable) -> Unit
    ) {
        RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getImageBySearch(searchText)
                .enqueue(object: Callback<PhotosResponseDTO?>{
                    override fun onFailure(call: Call<PhotosResponseDTO?>, t: Throwable) {
                        onFailure(call, t)
                    }

                    override fun onResponse(call: Call<PhotosResponseDTO?>, response: Response<PhotosResponseDTO?>) {
                        onResponse(call, response)
                    }

                })
    }
}