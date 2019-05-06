package com.kangarootech.flickr.ui.frgsearch

import com.kangarootech.flickr.dto.photos.PhotoDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        6.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


interface SearchContract {
    interface View {
        fun updateDefaultList(list: List<PhotoDTO>)
        fun updateResultList(list: List<PhotoDTO>)
        fun showProgress()
        fun hideProgress()
        fun showToast(message: String)
    }

    interface Presenter {

        fun getImageBySearch(searchText: String)
        fun getExploreImages()
    }
}