package com.bangkit.tursik.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkit.tursik.data.entity.PlaceEntity


@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaces(places: List<PlaceEntity>)

    @Query("SELECT * FROM places WHERE name LIKE '%' || :query || '%'")
    fun searchPlacesByName(query: String): List<PlaceEntity>
}