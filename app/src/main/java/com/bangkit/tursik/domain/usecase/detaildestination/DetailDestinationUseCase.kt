package com.bangkit.tursik.domain.usecase.detaildestination

import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface DetailDestinationUseCase {

    suspend fun getDestinationDetail(destionationName: String) : Flow<Result<DetailDestinationResponse>>
}