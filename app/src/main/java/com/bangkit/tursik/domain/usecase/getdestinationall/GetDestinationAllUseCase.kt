package com.bangkit.tursik.domain.usecase.getdestinationall

import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationAllUseCase {
    suspend fun getDestinationAll() : Flow<Result<DestinationAllResponse>>
}