package com.kangarootech.flickr.ui.frgsearch

import com.kangarootech.flickr.database.SearchHistoryEntity
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
        fun updateSearchHistoryList(list: List<SearchHistoryEntity>)
        fun updateSearchHistoryListByText(text: String)
        fun showProgress()
        fun hideProgress()
        fun showToast(message: String)
        fun setCancelButtonVisibility(visibility: Int)
        fun setClearTextButtonVisibility(visibility: Int)
        fun setAppBarExpanded(isExpanded: Boolean)
        fun clearSearchEdtFocus()
        fun clearSearchEdt()
        fun setSearchEdtText(text: String)
        fun setKeyboardVisibility(isVisible: Boolean)
        fun setSearchHistoryRecyclerVisibility(visibility: Int)
        fun navigateToImageActivity(photoId: String)
    }

    interface Presenter {

        fun onSearchTouched()
        fun onClickSearch(text: String)
        fun onClickCancel()
        fun onClickCancelClearText()
        fun onClickImage(model: PhotoDTO)
        fun onClickDeleteHistory(model: SearchHistoryEntity, position: Int)
        fun onEditTextTextChange(text: CharSequence?)

        fun getExploreImages()
    }
}