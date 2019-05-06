package com.kangarootech.flickr.ui.frgrecentimgs


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kangarootech.flickr.R
import com.kangarootech.flickr.Repository
import com.kangarootech.flickr.adapter.RecentImagesRecyclerAdapter
import com.kangarootech.flickr.dto.photos.PhotoDTO
import com.kangarootech.flickr.ui.actimage.ImageActivity
import com.kangarootech.flickr.util.RecyclerScrollListener
import kotlinx.android.synthetic.main.fragment_recent_images.*

class RecentImagesFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, RecentImagesContract.View {

    private val mPresenter by lazy { RecentImagesPresenter(this, Repository(context!!)) }
    private lateinit var mAdapter: RecentImagesRecyclerAdapter
    private val RECYCLER_ROW_ITEM_COUNT = 2
    private val RECYCLER_ITEM_CACHE_SIZE = 40
    private var isItemsLoading = false
    private var currentPage = 1
    private var lastPage = 1

    companion object {
        @JvmStatic
        fun newInstance() = RecentImagesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recent_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = RecentImagesRecyclerAdapter(mutableListOf()) {
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("photoId", it.id)
            startActivity(intent)
        }

        recyclerRecentImages.apply {
            layoutManager = GridLayoutManager(context, RECYCLER_ROW_ITEM_COUNT)
            adapter = mAdapter
            setItemViewCacheSize(RECYCLER_ITEM_CACHE_SIZE)
        }.also {
            it.addOnScrollListener(object : RecyclerScrollListener(it.layoutManager as GridLayoutManager) {
                override var isLoading: Boolean
                    get() = isItemsLoading
                    set(_) {}
                override var isLastPage: Boolean
                    get() = currentPage == lastPage
                    set(_) {}

                override fun loadMoreItems() {
                    mPresenter.getImagesByPage(currentPage)
                }

            })
        }

        swipeRefreshRecentImages.setOnRefreshListener(this)

        mPresenter.refreshImages()
    }

    override fun hideProgress() {
        if (swipeRefreshRecentImages.isRefreshing)
            swipeRefreshRecentImages.isRefreshing = false
        pbarRecentImages.hideLoading()
    }

    override fun showProgress() {
        pbarRecentImages.showLoading()
    }

    override fun updateList(list: List<PhotoDTO>) {
        mAdapter.updateList(list)
    }

    override fun appendToList(list: List<PhotoDTO>) {
        mAdapter.appendToList(list)
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onRefresh() {
        mPresenter.refreshImages()
    }

    override fun updateCurrentPage() {
        currentPage++
    }

    override fun updateLastPage(page: Int) {
        lastPage = page
    }
}
