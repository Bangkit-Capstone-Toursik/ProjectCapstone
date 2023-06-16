package com.bangkit.tursik.data.resource

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
import com.bangkit.tursik.other.SafeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ApiDataSource @Inject constructor(
    private val apiService: ApiService
) : SafeApiCall(){


     fun getDestinationPopular() : Flow<Result<DestinationPopularResponse>> {
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationPopular() })
        }
    }

     fun getDestinationRecomended() :Flow<Result<DestinationRecomededResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationRecomended() })
        }
    }

    fun getDestinationAll() :Flow<Result<DestinationAllResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getAllDestination() })
        }
    }
    fun getDestinationAlam() :Flow<Result<DestinationAlamResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationAlam() })
        }
    }
    fun getDestinationPendidikan() :Flow<Result<DestinationPendidikanResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationPendidikan() })
        }
    }
    fun getDestinationReligi() :Flow<Result<DestinationReligiResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationReligi() })
        }
    }

    fun getDestinationSejarah() :Flow<Result<DestinationSejarahResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationSejarah() })
        }
    }

    fun getDestinationDetail(destionationName: String) :Flow<Result<DetailDestinationResponse>>{
        return flow {
            emit(Result.Loading)
            emitAll(safeApiCall { apiService.getDestinationDetail(destionationName) })
        }
    }
}