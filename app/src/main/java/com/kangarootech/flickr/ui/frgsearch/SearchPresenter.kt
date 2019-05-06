package com.kangarootech.flickr.ui.frgsearch

import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.enums.StatusCodeEnum

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        6.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class SearchPresenter(
        private val view: SearchContract.View,
        private val mRepository: Repository
) : SearchContract.Presenter {

    override fun getImageBySearch(searchText: String) {
        view.showProgress()
        mRepository.getImageBySearch(searchText) { _resultDTO, _resultCode ->
            when (_resultCode) {
                StatusCodeEnum.OK.value -> {
                    view.updateResultList(_resultDTO!!.photos.photoList)
                }
                StatusCodeEnum.CONNECTION_ERROR.value -> view.showToast("Connection problem")
                StatusCodeEnum.SERVICE_UNAVAILABLE.value -> view.showToast("Service unavailable")
                StatusCodeEnum.NO_CONTENT.value -> view.showToast("We couldn't find any photo to show")
            }
            view.hideProgress()
        }
    }

    override fun getExploreImages() {
        view.showProgress()
        mRepository.getExploreImages { _resultDTO, _resultCode ->
            when (_resultCode) {
                StatusCodeEnum.OK.value -> {
                    view.updateDefaultList(_resultDTO!!.photos.photoList)
                }
                StatusCodeEnum.CONNECTION_ERROR.value -> view.showToast("Connection problem")
                StatusCodeEnum.SERVICE_UNAVAILABLE.value -> view.showToast("Service unavailable")
                StatusCodeEnum.NO_CONTENT.value -> view.showToast("We couldn't find any photo to show")
            }
            view.hideProgress()
        }
    }
}