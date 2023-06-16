package com.bangkit.tursik.data.resource

import com.bangkit.tursik.data.dao.WishlistDao
import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.other.SafeDbCall
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import com.bangkit.tursik.other.Result

class WishlistDataSource @Inject constructor(private val dao: WishlistDao) :
    SafeDbCall() {

    fun getAllFavouriteUser(): Flow<Result<List<WishlistEntity>>> {
        return safeDbCall { dao.getAllFavouriteUser().first() }
    }

    suspend fun setUserAsFavourite(user: WishlistEntity): Flow<Result<Long>> {
        return safeDbCall { dao.setUserAsFavourite(user = user) }
    }

    suspend fun deleteFavouriteUser(user: WishlistEntity): Flow<Result<Int>> {
        return safeDbCall { dao.deleteFavouriteUser(user = user) }
    }
}