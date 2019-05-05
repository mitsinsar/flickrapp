package com.kangarootech.flickr.ui.frgrecentimgs

import com.kangarootech.flickr.dto.photos.PhotoDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


interface RecentImagesContract {

    interface View {
        fun hideProgress()
        fun showProgress()
        fun updateList(list: List<PhotoDTO>)
        fun appendToList(list: List<PhotoDTO>)
        fun showToast(message: String)
        fun updateCurrentPage()
        fun updateLastPage(page: Int)

    }

    interface Presenter {
        fun getImagesByPage(page: Int)
        fun refreshImages()
    }
}