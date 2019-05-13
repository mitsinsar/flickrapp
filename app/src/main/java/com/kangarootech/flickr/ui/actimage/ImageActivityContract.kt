package com.kangarootech.flickr.ui.actimage

import com.kangarootech.flickr.datalayer.network.dto.photodetail.PhotoDetailDTO

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


interface ImageActivityContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun updateImageInfo(model: PhotoDetailDTO)
        fun showToast(message: String)
        fun loadOwnerIcon(iconUrl: String)
        fun loadImage(imageUrl: String)
        fun setInfoBarsVisibility()
    }

    interface Presenter {
        fun getImageDetailsById(photoId: String)
        fun onClickImage()
    }
}