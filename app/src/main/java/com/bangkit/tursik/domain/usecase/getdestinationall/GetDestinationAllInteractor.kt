package com.bangkit.tursik.domain.usecase.getdestinationall

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetDestinationAllInteractor @Inject constructor(
    private val repository: PlaceRepository
) : GetDestinationAllUseCase {

    override suspend fun getDestinationAll(): Flow<Result<DestinationAllResponse>> {
        return repository.getDestinationAll()
    }
}