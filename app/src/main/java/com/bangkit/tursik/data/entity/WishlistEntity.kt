package com.bangkit.tursik.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_github_user")
data class WishlistEntity(

    @ColumnInfo(name = "login")
    val login: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val price: Int? = null,

    @ColumnInfo(name = "avatar_url")
    val location: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "favourite")
    val favourite: Boolean? = null
)
