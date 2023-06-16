package com.bangkit.tursik.domain.usecase.getdestinationpopular

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetDestinationPopulerInteractor @Inject constructor(
    private val repository: PlaceRepository) : GetDestinationPopularUseCase {

    override suspend fun getDestinationPopular(): Flow<Result<DestinationPopularResponse>> {
        return repository.getDestinationPopular()
    }
}