package com.bangkit.tursik.domain.usecase.getdestinationrecomend

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDestinationRecomendedInteractor
    @Inject constructor(private val repository: PlaceRepository)
    : GetDestinationRecomendedUseCase {

     override suspend fun getDestinationRecomended(): Flow<Result<DestinationRecomededResponse>> {
        return repository.getDestinationRecomended()
    }
}