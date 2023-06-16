package com.bangkit.tursik.di

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.repository.WishlistRepository
import com.bangkit.tursik.domain.repository.PlaceRepositoryImpl
import com.bangkit.tursik.domain.repository.WishlistRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindGetPlaceListRepository(repositoryPlace: PlaceRepositoryImpl): PlaceRepository

    @Binds
    fun bindGetWishlistRepository(repositoryPlace: WishlistRepositoryImpl): WishlistRepository

}