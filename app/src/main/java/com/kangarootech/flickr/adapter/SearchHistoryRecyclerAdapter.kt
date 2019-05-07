package com.kangarootech.flickr.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kangarootech.flickr.database.SearchHistoryEntity
import com.kangarootech.flickr.viewholder.SearchHistoryViewHolder

////////////////////////////
//    Mithat Sinan Sarı   //
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


class SearchHistoryRecyclerAdapter(
        private var items: List<SearchHistoryEntity>,
        private val onClickSearch: (SearchHistoryEntity) -> Unit,
        private val onClickDelete: (SearchHistoryEntity, Int) -> Unit
) : RecyclerView.Adapter<SearchHistoryViewHolder>() {

    private var itemsFromDatabase: List<SearchHistoryEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchHistoryViewHolder(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        holder.bind(items[position], position, onClickSearch, onClickDelete)
    }

    fun updateList(list: List<SearchHistoryEntity>) {
        this.items = list.asReversed()
        itemsFromDatabase = list.asReversed()
        notifyDataSetChanged()
    }

    fun updateListByText(text: String) {
        if (text.isEmpty())
            this.items = itemsFromDatabase
        else {
            val listOrderedByText: List<SearchHistoryEntity> = itemsFromDatabase
                    .filter { it.searchText.startsWith(text) }
                    .sortedBy { it.searchText }

            this.items = listOrderedByText
        }
        notifyDataSetChanged()
    }
}