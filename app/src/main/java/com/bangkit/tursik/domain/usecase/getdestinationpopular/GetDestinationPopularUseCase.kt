package com.bangkit.tursik.domain.usecase.getdestinationpopular

import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow


interface GetDestinationPopularUseCase {

    suspend fun getDestinationPopular() : Flow<Result<DestinationPopularResponse>>
}