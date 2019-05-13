package com.kangarootech.flickr

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kangarootech.flickr.adapter.MainActPagerAdapter
import com.kangarootech.flickr.datalayer.Repository
import com.kangarootech.flickr.ui.actimage.ImageActivityContract
import com.kangarootech.flickr.ui.actimage.ImageActivityPresenter
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesContract
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesFragment
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesPresenter
import com.kangarootech.flickr.ui.frgsearch.SearchContract
import com.kangarootech.flickr.ui.frgsearch.SearchFragment
import com.kangarootech.flickr.ui.frgsearch.SearchPresenter

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        13.05.2019      //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


object DependencyUtil {

    fun getRepository(context: Context) = Repository(context)

    fun getMainFragments(): List<Fragment> = listOf(RecentImagesFragment.newInstance(), SearchFragment.newInstance())

    fun getMainPagerAdapter(fm: FragmentManager) = MainActPagerAdapter(fm)

    fun getImagePresenter(view: ImageActivityContract.View, repository: Repository) =
        ImageActivityPresenter(view, repository)

    fun getRecentImagesPresenter(view: RecentImagesContract.View, repository: Repository) =
        RecentImagesPresenter(view, repository)

    fun getSearchPresenter(view: SearchContract.View, repository: Repository) =
        SearchPresenter(view, repository)
}