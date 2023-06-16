package com.bangkit.tursik.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.tursik.data.dao.PlaceDao
import com.bangkit.tursik.data.entity.PlaceEntity

@Database(entities = [PlaceEntity::class], version = 1)
abstract class PlaceDb : RoomDatabase() {
    abstract fun placeDao(): PlaceDao

    companion object {
        private const val DATABASE_NAME = "my_database"

        @Volatile
        private var instance: PlaceDb? = null

        fun getInstance(context: Context): PlaceDb {
            return instance ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceDb::class.java,
                    DATABASE_NAME
                ).build()
                instance = db
                db
            }
        }
    }
}