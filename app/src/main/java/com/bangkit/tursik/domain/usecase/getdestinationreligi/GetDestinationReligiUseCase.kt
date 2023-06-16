package com.bangkit.tursik.domain.usecase.getdestinationreligi

import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationReligiUseCase {

    suspend fun getDestinationReligi() : Flow<Result<DestinationReligiResponse>>
}