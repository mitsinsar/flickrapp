package com.kangarootech.flickr.ui.frgrecentimgs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kangarootech.flickr.R

class RecentImagesFragment : Fragment() {

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


}
