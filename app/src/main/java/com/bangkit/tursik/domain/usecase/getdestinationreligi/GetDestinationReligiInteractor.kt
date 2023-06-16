package com.bangkit.tursik.domain.usecase.getdestinationreligi

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.domain.usecase.getdestinationrecomend.GetDestinationRecomendedUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDestinationReligiInteractor @Inject constructor(private val repository: PlaceRepository)
    : GetDestinationReligiUseCase {

    override suspend fun getDestinationReligi(): Flow<Result<DestinationReligiResponse>> {
        return repository.getDestinationReligi()
    }
}