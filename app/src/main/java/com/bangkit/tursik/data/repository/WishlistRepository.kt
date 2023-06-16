package com.bangkit.tursik.data.repository

import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.data.response.DataItem
import kotlinx.coroutines.flow.Flow
import com.bangkit.tursik.other.Result

interface WishlistRepository {

    fun getAllFavouriteUser(): Flow<Result<List<WishlistEntity>>>

    suspend fun setUserAsFavourite(user: WishlistEntity): Flow<Result<Long>>

    suspend fun deleteFavouriteUser(user: WishlistEntity): Flow<Result<Int>>


}