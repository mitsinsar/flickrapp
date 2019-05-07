package com.kangarootech.flickr.ui.frgrecentimgs

import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.dto.photos.PhotoDTO
import com.kangarootech.flickr.enums.StatusCodeEnum
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesContract.Presenter
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesContract.View

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        5.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class RecentImagesPresenter(
    private val view: View,
    private val mRepository: Repository
) : Presenter {

    override fun onClickImage(image: PhotoDTO) {
        view.navigateToImageActivity(image.id)
    }

    override fun getImagesByPage(page: Int) {
        view.showProgress()
        mRepository.getImages(page) { _resultDTO, _resultCode ->
            when (_resultCode) {
                StatusCodeEnum.OK.value -> {
                    view.appendToList(_resultDTO!!.photos.photoList)
                    view.updateCurrentPage()
                }
                StatusCodeEnum.CONNECTION_ERROR.value -> view.showToast("Connection problem")
                StatusCodeEnum.SERVICE_UNAVAILABLE.value -> view.showToast("Service unavailable")
                StatusCodeEnum.NO_CONTENT.value -> view.showToast("We couldn't find any photo to show")
            }
            view.hideProgress()
        }
    }

    override fun refreshImages() {
        view.showProgress()
        mRepository.getImages(1) { _resultDTO, _resultCode ->
            when (_resultCode) {
                StatusCodeEnum.OK.value -> {
                        view.updateList(_resultDTO!!.photos.photoList)
                        view.updateLastPage(_resultDTO.photos.pages)
                }
                StatusCodeEnum.CONNECTION_ERROR.value -> view.showToast("Connection problem.")
                StatusCodeEnum.SERVICE_UNAVAILABLE.value -> view.showToast("Service unavailable")
                StatusCodeEnum.NO_CONTENT.value -> view.showToast("We couldn't find any photo to show")
            }
            view.hideProgress()
        }
    }
}