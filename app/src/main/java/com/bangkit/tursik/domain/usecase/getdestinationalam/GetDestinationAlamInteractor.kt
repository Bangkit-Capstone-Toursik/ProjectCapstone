package com.bangkit.tursik.domain.usecase.getdestinationalam

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDestinationAlamInteractor @Inject constructor(
    private val repository: PlaceRepository
) : GetDestinationAlamUseCase {

    override suspend fun getDestinationAlam(): Flow<Result<DestinationAlamResponse>> {
        return repository.getDestinationAlam()
    }
}