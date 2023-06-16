package com.bangkit.tursik.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "places")
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val address: String,
    val rating: Float
)