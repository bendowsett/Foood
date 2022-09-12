package com.example.foood.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Defines a database and specifies data tables that will be used.
 * Version is incremented as new tables/columns are added/removed/changed.
 * You can optionally use this class for one-time setup, such as pre-populating a database.
 */
@Database(entities = arrayOf(Favorite::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    //.createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}