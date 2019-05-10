package com.kangarootech.flickr.ui.frgsearch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.kangarootech.flickr.R
import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.adapter.SearchHistoryRecyclerAdapter
import com.kangarootech.flickr.adapter.SearchRecyclerAdapter
import com.kangarootech.flickr.database.SearchHistoryEntity
import com.kangarootech.flickr.dto.photos.PhotoDTO
import com.kangarootech.flickr.ui.actimage.ImageActivity
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), View.OnClickListener, View.OnFocusChangeListener, SearchContract.View, TextWatcher,
    TextView.OnEditorActionListener {

    private val appBar by lazy { activity!!.findViewById<AppBarLayout>(R.id.appBarLayoutMainAct) }
    private val mPresenter by lazy { SearchPresenter(this, Repository(context!!)) }
    private lateinit var mAdapterDefault: SearchRecyclerAdapter
    private lateinit var mAdapterSearchResult: SearchRecyclerAdapter
    private lateinit var mAdapterSearchHistory: SearchHistoryRecyclerAdapter

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapters()
        initRecyclerViews()

        btnCancel.setOnClickListener(this)
        btnCancelClearText.setOnClickListener(this)
        edtSearch.apply {
            setOnClickListener(this@SearchFragment)
            setOnEditorActionListener(this@SearchFragment)
            onFocusChangeListener = this@SearchFragment
            addTextChangedListener(this@SearchFragment)
        }

        mPresenter.getExploreImages()
    }

    private fun initAdapters() {

        mAdapterSearchHistory = SearchHistoryRecyclerAdapter(listOf(),
            onClickSearch = {
                mPresenter.onClickSearch(it.searchText)
            },
            onClickDelete = { _item, _position ->
                mPresenter.onClickDeleteHistory(_item, _position)
            })

        mAdapterSearchResult = SearchRecyclerAdapter(listOf()) {
            mPresenter.onClickImage(it)
        }

        mAdapterDefault = SearchRecyclerAdapter(listOf()) {
            mPresenter.onClickImage(it)
        }
    }

    private fun initRecyclerViews() {

        recyclerSearchHistory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterSearchHistory
        }

        recyclerSearchResult.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = mAdapterSearchResult
        }

        recyclerDefaultImages.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = mAdapterDefault
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnCancel.id -> {
                mPresenter.onClickCancel()
                recyclerSearchResult replaceWith recyclerDefaultImages
            }
            btnCancelClearText.id -> {
                mPresenter.onClickCancelClearText()
            }
        }
    }

    override fun clearSearchEdtFocus() {
        edtSearch.clearFocus()
    }

    override fun clearSearchEdt() {
        edtSearch.text.clear()
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when (v?.id) {
            edtSearch.id -> {
                if (hasFocus) {
                    mPresenter.onSearchTouched()
                    recyclerDefaultImages replaceWith recyclerSearchResult
                }
            }
        }
    }

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mPresenter.onEditTextTextChange(s)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH
            && edtSearch.text.isNotBlank()
        ) {
            mPresenter.onClickSearch(edtSearch.text.toString())
        }
        return false
    }

    override fun updateDefaultList(list: List<PhotoDTO>) {
        mAdapterDefault.updateList(list)
    }

    override fun updateResultList(list: List<PhotoDTO>) {
        mAdapterSearchResult.updateList(list)
        recyclerSearchResult.smoothScrollToPosition(0)
    }

    override fun updateSearchHistoryList(list: List<SearchHistoryEntity>) {
        mAdapterSearchHistory.updateList(list)
    }

    override fun updateSearchHistoryListByText(text: String) {
        mAdapterSearchHistory.updateListByText(text)
    }

    override fun setCancelButtonVisibility(visibility: Int) {
        btnCancel.visibility = visibility
    }

    override fun setSearchEdtText(text: String) {
        if (text != edtSearch.text.toString())
            edtSearch.setText(text)
    }

    override fun setClearTextButtonVisibility(visibility: Int) {
        btnCancelClearText.visibility = visibility
    }

    override fun setSearchHistoryRecyclerVisibility(visibility: Int) {
        recyclerSearchHistory.visibility = visibility
    }

    override fun setAppBarExpanded(isExpanded: Boolean) {
        appBar.setExpanded(isExpanded)
    }

    override fun showProgress() {
        pbarSearch.showLoading()
    }

    override fun hideProgress() {
        pbarSearch.hideLoading()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun setKeyboardVisibility(isVisible: Boolean) {
        val imm = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity!!.currentFocus
        if (view == null) {
            view = View(activity)
        }
        if (isVisible) {
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        } else {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun navigateToImageActivity(photoId: String) {
        val intent = Intent(context, ImageActivity::class.java)
        intent.putExtra("photoId", photoId)
        startActivity(intent)
    }

    private infix fun RecyclerView.replaceWith(recycler: RecyclerView) {
        this.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

}
