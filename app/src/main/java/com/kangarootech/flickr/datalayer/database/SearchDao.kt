package com.kangarootech.flickr.datalayer.database

import androidx.room.*

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewText(text: SearchHistoryEntity)

    @Delete
    fun deleteText(text: SearchHistoryEntity)

    @Query("SELECT * FROM table_search_history")
    fun getSearchHistory(): List<SearchHistoryEntity>
}