package com.bangkit.tursik.domain.usecase.getdestinationpendidikan

import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationPendidikanUseCase {

    suspend fun getDestinationPendidikan() : Flow<Result<DestinationPendidikanResponse>>
}