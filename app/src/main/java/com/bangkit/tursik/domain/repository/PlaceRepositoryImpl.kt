package com.bangkit.tursik.domain.repository

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.resource.ApiDataSource
import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.data.service.ApiService
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PlaceRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource
): PlaceRepository {


    override suspend fun getDestinationPopular(): Flow<Result<DestinationPopularResponse>> {
        return apiDataSource.getDestinationPopular()
    }

     override suspend fun getDestinationRecomended(): Flow<Result<DestinationRecomededResponse>> {
        return apiDataSource.getDestinationRecomended()
    }

    override suspend fun getDestinationAll(): Flow<Result<DestinationAllResponse>> {
       return apiDataSource.getDestinationAll()
    }

    override suspend fun getDestinationAlam(): Flow<Result<DestinationAlamResponse>> {
        return apiDataSource.getDestinationAlam()
    }

    override suspend fun getDestinationPendidikan(): Flow<Result<DestinationPendidikanResponse>> {
        return apiDataSource.getDestinationPendidikan()
    }

    override suspend fun getDestinationReligi(): Flow<Result<DestinationReligiResponse>> {
        return apiDataSource.getDestinationReligi()
    }

    override suspend fun getDestinationSejarah(): Flow<Result<DestinationSejarahResponse>> {
        return apiDataSource.getDestinationSejarah()
    }

    override suspend fun getDestinationDetail(destionationName:String): Flow<Result<DetailDestinationResponse>> {
        return apiDataSource.getDestinationDetail(destionationName)
    }
}