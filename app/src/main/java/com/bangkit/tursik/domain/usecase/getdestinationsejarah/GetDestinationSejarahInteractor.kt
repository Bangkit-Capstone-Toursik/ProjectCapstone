package com.bangkit.tursik.domain.usecase.getdestinationsejarah

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import com.bangkit.tursik.domain.usecase.getdestinationreligi.GetDestinationReligiUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 class GetDestinationSejarahInteractor@Inject constructor(private val repository: PlaceRepository)
    : GetDestinationSejarahUseCase {

     override suspend fun getDestinationSejarah(): Flow<Result<DestinationSejarahResponse>> {
         return repository.getDestinationSejarah()
     }
}