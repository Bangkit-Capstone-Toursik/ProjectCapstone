package com.bangkit.tursik.domain.usecase.wishlist

import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.data.repository.WishlistRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import com.bangkit.tursik.other.Result

class WishlistInteractor @Inject constructor(
    private val favouriteUserRepository: WishlistRepository
) : WishlistUseCase {

    override fun getAllFavouriteUser(): Flow<Result<List<WishlistEntity>>> {
        return favouriteUserRepository.getAllFavouriteUser()
    }

    override suspend fun setUserAsFavourite(user: WishlistEntity): Flow<Result<Long>> {
        return favouriteUserRepository.setUserAsFavourite(user = user)
    }

    override suspend fun deleteFavouriteUser(user: WishlistEntity): Flow<Result<Int>> {
        return favouriteUserRepository.deleteFavouriteUser(user = user)
    }
}