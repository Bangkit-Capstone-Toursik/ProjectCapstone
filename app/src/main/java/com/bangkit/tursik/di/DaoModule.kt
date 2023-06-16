package com.bangkit.tursik.di

import com.bangkit.tursik.data.dao.WishlistDao
import com.bangkit.tursik.data.database.GithubUserDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideFavouriteUserDao(githubUserDb: GithubUserDb): WishlistDao {
        return githubUserDb.favouriteUserDao()
    }
}