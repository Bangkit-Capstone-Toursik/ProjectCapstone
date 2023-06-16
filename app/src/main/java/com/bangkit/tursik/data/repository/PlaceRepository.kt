package com.bangkit.tursik.data.repository

import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {

    suspend fun getDestinationPopular() : Flow<Result<DestinationPopularResponse>>

    suspend fun getDestinationRecomended(): Flow<Result<DestinationRecomededResponse>>

    suspend fun getDestinationAll(): Flow<Result<DestinationAllResponse>>

    suspend fun getDestinationAlam(): Flow<Result<DestinationAlamResponse>>

    suspend fun getDestinationPendidikan(): Flow<Result<DestinationPendidikanResponse>>

    suspend fun getDestinationReligi(): Flow<Result<DestinationReligiResponse>>

    suspend fun getDestinationSejarah(): Flow<Result<DestinationSejarahResponse>>
}