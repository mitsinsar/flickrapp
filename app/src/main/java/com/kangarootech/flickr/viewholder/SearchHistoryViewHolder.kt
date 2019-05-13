package com.kangarootech.flickr.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.R
import com.kangarootech.flickr.datalayer.database.SearchHistoryEntity

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class SearchHistoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_search_history, parent, false)
) {
    private val searchText by lazy { itemView.findViewById<TextView>(R.id.txtSearchHistory) }
    private val btnSearch by lazy { itemView.findViewById<LinearLayout>(R.id.layoutBtnSearchHistory) }
    private val btnDelete by lazy { itemView.findViewById<ImageView>(R.id.imgviewBtnSearchHistoryRemove) }

    fun bind(model: SearchHistoryEntity,
             position: Int,
             onClickSearch: (SearchHistoryEntity) -> Unit,
             onClickDelete: (SearchHistoryEntity, Int) -> Unit) {
        searchText.text = model.searchText

        btnSearch.setOnClickListener {
            onClickSearch(model)
        }

        btnDelete.setOnClickListener {
            onClickDelete(model, position)
        }
    }
}