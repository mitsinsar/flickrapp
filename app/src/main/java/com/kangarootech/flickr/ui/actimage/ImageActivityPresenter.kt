package com.kangarootech.flickr.ui.actimage

import com.kangarootech.flickr.datalayer.Repository
import com.kangarootech.flickr.enums.StatusCodeEnum
import com.kangarootech.flickr.ui.actimage.ImageActivityContract.Presenter
import com.kangarootech.flickr.ui.actimage.ImageActivityContract.View

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class ImageActivityPresenter(private val view: View, private val mRepository: Repository) : Presenter {

    override fun onClickImage() {
        view.setInfoBarsVisibility()
    }

    override fun getImageDetailsById(photoId: String) {
        view.showProgress()
        mRepository.getImageDetailById(photoId) { _resultDTO, _resultCode ->
            when (_resultCode) {
                StatusCodeEnum.OK.value -> {
                    view.updateImageInfo(_resultDTO!!.photo)
                    view.loadOwnerIcon(_resultDTO.getOwnerIconUrl())
                    view.loadImage(_resultDTO.getImageUrl())
                }
                StatusCodeEnum.CONNECTION_ERROR.value -> view.showToast("Connection problem")
                StatusCodeEnum.SERVICE_UNAVAILABLE.value -> view.showToast("Service unavailable")
                StatusCodeEnum.NO_CONTENT.value -> view.showToast("We couldn't find photo to show you")
            }
            view.hideProgress()
        }
    }
}