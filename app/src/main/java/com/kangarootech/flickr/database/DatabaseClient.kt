package com.kangarootech.flickr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        7.05.2019       //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////

@Database(entities = [SearchHistoryEntity::class], version = 1)
abstract class DatabaseClient : RoomDatabase() {

    abstract fun getDao(): SearchDao

    companion object {
        private var INSTANCE: DatabaseClient? = null

        fun getInstance(context: Context): DatabaseClient {
            synchronized(DatabaseClient::class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        DatabaseClient::class.java, "flickrhipodb"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}