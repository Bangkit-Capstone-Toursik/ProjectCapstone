package com.bangkit.tursik.domain.usecase.getdestinationpendidikan

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.domain.usecase.getdestinationall.GetDestinationAllUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDestinationPendidikanInteractor @Inject constructor(
    private val repository: PlaceRepository
) : GetDestinationPendidikanUseCase {



    override suspend fun getDestinationPendidikan(): Flow<Result<DestinationPendidikanResponse>> {
        return repository.getDestinationPendidikan()
    }
}