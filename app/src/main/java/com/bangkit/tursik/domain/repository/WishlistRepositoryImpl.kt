package com.bangkit.tursik.domain.repository

import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.data.repository.WishlistRepository
import com.bangkit.tursik.data.resource.WishlistDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import com.bangkit.tursik.other.Result

class WishlistRepositoryImpl @Inject constructor(
    private val favouriteUserDataSource: WishlistDataSource
) : WishlistRepository {

    override fun getAllFavouriteUser(): Flow<Result<List<WishlistEntity>>> {
        return favouriteUserDataSource.getAllFavouriteUser()
    }

    override suspend fun setUserAsFavourite(user: WishlistEntity): Flow<Result<Long>> {
        return favouriteUserDataSource.setUserAsFavourite(user = user)
    }

    override suspend fun deleteFavouriteUser(user: WishlistEntity): Flow<Result<Int>> {
        return favouriteUserDataSource.deleteFavouriteUser(user = user)
    }
}