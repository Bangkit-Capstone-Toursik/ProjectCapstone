package com.bangkit.tursik.domain.usecase.detaildestination

import com.bangkit.tursik.data.repository.PlaceRepository
import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.domain.usecase.getdestinationalam.GetDestinationAlamUseCase
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailDeastinationInteractor @Inject constructor(
    private val repository: PlaceRepository
) : DetailDestinationUseCase {

    override suspend fun getDestinationDetail(destionationName: String): Flow<Result<DetailDestinationResponse>> {
       return repository.getDestinationDetail(destionationName)
    }
}