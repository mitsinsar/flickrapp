package com.kangarootech.flickr.ui.frgsearch

import android.view.View
import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.database.SearchHistoryEntity
import com.kangarootech.flickr.dto.photos.PhotoDTO
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

    override fun onSearchTouched() {
        view.setCancelButtonVisibility(View.VISIBLE)
        view.updateSearchHistoryList(mRepository.getHistoryList())
        view.setSearchHistoryRecyclerVisibility(View.VISIBLE)
        view.setKeyboardVisibility(isVisible = true)
        view.setAppBarExpanded(false)
    }

    override fun onClickSearch(text: String) {
        getImageBySearch(text)
        mRepository.insertToDatabase(SearchHistoryEntity(text))
        view.setKeyboardVisibility(isVisible = false)
        view.setSearchHistoryRecyclerVisibility(View.GONE)
        view.setSearchEdtText(text)
    }

    override fun onClickCancel() {
        view.setKeyboardVisibility(isVisible = false)
        view.clearSearchEdtFocus()
        view.clearSearchEdt()
        view.setAppBarExpanded(true)
        view.setCancelButtonVisibility(View.GONE)
        view.setClearTextButtonVisibility(View.GONE)
        view.setSearchHistoryRecyclerVisibility(View.GONE)
    }

    override fun onClickCancelClearText() {
        view.updateSearchHistoryList(mRepository.getHistoryList())
        view.clearSearchEdt()
        view.setClearTextButtonVisibility(View.GONE)
        view.setSearchHistoryRecyclerVisibility(View.VISIBLE)
        view.setKeyboardVisibility(isVisible = true)
    }

    override fun onClickImage(model: PhotoDTO) {
        view.navigateToImageActivity(model.id)
    }

    override fun onClickDeleteHistory(model: SearchHistoryEntity, position: Int) {
        mRepository.deleteFromDatabase(model)
        view.updateSearchHistoryList(mRepository.getHistoryList())
    }

    override fun onEditTextTextChange(text: CharSequence?) {
        view.setClearTextButtonVisibility(View.VISIBLE)
        view.updateSearchHistoryListByText(text.toString())
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

    private fun getImageBySearch(searchText: String) {
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
}