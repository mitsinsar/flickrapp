package com.kangarootech.flickr

import android.content.Context
import android.os.AsyncTask
import com.kangarootech.flickr.database.DatabaseClient
import com.kangarootech.flickr.database.SearchDao
import com.kangarootech.flickr.database.SearchHistoryEntity
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

    private val mDatabase by lazy { DatabaseClient.getInstance(context) }
    private val mSearchDao by lazy { mDatabase.getDao() }

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

    fun getExploreImages(onResult: (PhotosResponseDTO?, resultCode: Int) -> Unit) {
        if (hasConnection(context)) {
            RetrofitClient.getClient()
                .create(ApiService::class.java)
                .getExploreImages()
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

    fun insertToDatabase(item: SearchHistoryEntity) {
        InsertAsyncTask(mSearchDao).execute(item)
    }

    fun deleteFromDatabase(item: SearchHistoryEntity) {
        DeleteAsyncTask(mSearchDao).execute(item)
    }

    fun getHistoryList(): List<SearchHistoryEntity> {
        return GetHistoryAsyncTask(mSearchDao).execute().get()
    }

    private class InsertAsyncTask(val mDao: SearchDao) : AsyncTask<SearchHistoryEntity, Unit, Unit>() {
        override fun doInBackground(vararg params: SearchHistoryEntity?) {
            mDao.insertNewText(params.first()!!)
        }
    }

    private class DeleteAsyncTask(val mDao: SearchDao) : AsyncTask<SearchHistoryEntity, Unit, Unit>() {
        override fun doInBackground(vararg params: SearchHistoryEntity?) {
            mDao.deleteText(params.first()!!)
        }
    }

    private class GetHistoryAsyncTask(val mDao: SearchDao) : AsyncTask<Unit, Unit, List<SearchHistoryEntity>>() {
        override fun doInBackground(vararg params: Unit?): List<SearchHistoryEntity> {
            return mDao.getSearchHistory()
        }
    }
}