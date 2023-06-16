package com.bangkit.tursik.domain.usecase.getdestinationsejarah

import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow

interface GetDestinationSejarahUseCase {

    suspend fun getDestinationSejarah() : Flow<Result<DestinationSejarahResponse>>
}