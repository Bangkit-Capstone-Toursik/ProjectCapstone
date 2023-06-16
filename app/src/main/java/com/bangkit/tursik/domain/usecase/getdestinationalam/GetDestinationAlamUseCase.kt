package com.bangkit.tursik.domain.usecase.getdestinationalam

import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationAlamUseCase {

    suspend fun getDestinationAlam() : Flow<Result<DestinationAlamResponse>>
}