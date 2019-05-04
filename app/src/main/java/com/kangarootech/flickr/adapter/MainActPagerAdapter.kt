package com.kangarootech.flickr.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kangarootech.flickr.ui.frgrecentimgs.RecentImagesFragment
import com.kangarootech.flickr.ui.frgsearch.SearchFragment

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        4.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class MainActPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val FRAGMENT_COUNT = 2
    private val fragmentRecentImages by lazy { RecentImagesFragment.newInstance() }
    private val fragmentSearch by lazy { SearchFragment.newInstance() }

    override fun getItem(position: Int) = when (position) {
        0 -> fragmentRecentImages
        else -> fragmentSearch
    }

    override fun getCount() = FRAGMENT_COUNT
}