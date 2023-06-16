package com.bangkit.tursik.domain.usecase.getdestinationrecomend


import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationRecomendedUseCase {
    suspend fun getDestinationRecomended() : Flow<Result<DestinationRecomededResponse>>
}