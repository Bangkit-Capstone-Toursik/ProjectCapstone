package com.bangkit.tursik.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkit.tursik.data.entity.WishlistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Query("SELECT * FROM saved_github_user WHERE favourite = 1")
    fun getAllFavouriteUser(): Flow<List<WishlistEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setUserAsFavourite(user: WishlistEntity): Long

    @Delete
    suspend fun deleteFavouriteUser(user: WishlistEntity): Int
}