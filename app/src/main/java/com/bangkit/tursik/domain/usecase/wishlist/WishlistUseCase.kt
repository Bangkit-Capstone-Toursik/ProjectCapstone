package com.bangkit.tursik.domain.usecase.wishlist

import com.bangkit.tursik.data.entity.WishlistEntity
import kotlinx.coroutines.flow.Flow
import com.bangkit.tursik.other.Result

interface WishlistUseCase {

    fun getAllFavouriteUser(): Flow<Result<List<WishlistEntity>>>

    suspend fun setUserAsFavourite(user: WishlistEntity): Flow<Result<Long>>

    suspend fun deleteFavouriteUser(user: WishlistEntity): Flow<Result<Int>>
}