package com.kangarootech.flickr.network

import com.kangarootech.flickr.enums.ApiEnum
import com.kangarootech.flickr.network.response.PhotoDetailsResponseDTO
import com.kangarootech.flickr.network.response.PhotosResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        4.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


interface ApiService {

    @GET("?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    fun getRecentImages(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = ApiEnum.API_KEY.toString()
    ): Call<PhotosResponseDTO?>

    @GET("?method=flickr.photos.getInfo&format=json&nojsoncallback=1")
    fun getImageDetail(
        @Query("photo_id") photoId: String,
        @Query("api_key") apiKey: String = ApiEnum.API_KEY.toString()
    ): Call<PhotoDetailsResponseDTO>

    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1")
    fun getImageBySearch(
            @Query("text") searchText: String,
            @Query("api_key") apiKey: String = ApiEnum.API_KEY.toString()
    ): Call<PhotosResponseDTO?>

    @GET("?method=flickr.groups.pools.getPhotos&format=json&nojsoncallback=1")
    fun getExploreImages(
            @Query("group_id") groupId: String = ApiEnum.EXPLORE_GROUP_ID.toString(),
            @Query("api_key") apiKey: String = ApiEnum.API_KEY.toString()
    ): Call<PhotosResponseDTO?>
}