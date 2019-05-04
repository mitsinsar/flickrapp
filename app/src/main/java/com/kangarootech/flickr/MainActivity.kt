package com.kangarootech.flickr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.kangarootech.flickr.adapter.MainActPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerMainAct.apply {
            adapter = MainActPagerAdapter(supportFragmentManager)
        }
        tabLayoutMainAct.apply {
            setupWithViewPager(viewPagerMainAct)
            getTabAt(0)!!.icon = ResourcesCompat
                    .getDrawable(resources, R.drawable.ic_tablayout_image, null)
            getTabAt(1)!!.icon = ResourcesCompat
                    .getDrawable(resources, R.drawable.ic_tablayout_search, null)
        }

    }
}
