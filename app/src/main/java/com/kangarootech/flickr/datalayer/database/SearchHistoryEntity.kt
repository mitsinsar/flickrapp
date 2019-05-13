package com.kangarootech.flickr.datalayer.database

import androidx.room.Entity
import androidx.room.PrimaryKey

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////

@Entity(tableName = "table_search_history")
data class SearchHistoryEntity(
    @PrimaryKey(autoGenerate = false)
    val searchText: String
)