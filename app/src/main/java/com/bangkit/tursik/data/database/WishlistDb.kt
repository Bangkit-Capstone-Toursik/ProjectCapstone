package com.bangkit.tursik.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.tursik.data.dao.WishlistDao
import com.bangkit.tursik.data.entity.WishlistEntity

const val dbVersion = 1
const val exportScheme = false

@Database(
    entities = [
        WishlistEntity::class
    ], version = dbVersion, exportSchema = exportScheme
)

abstract class GithubUserDb : RoomDatabase() {
    abstract fun favouriteUserDao(): WishlistDao
}