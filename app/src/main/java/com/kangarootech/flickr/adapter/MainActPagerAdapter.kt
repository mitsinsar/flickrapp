package com.kangarootech.flickr.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kangarootech.flickr.DependencyUtil

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

    private val fragments by lazy { DependencyUtil.getMainFragments() }

    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
}