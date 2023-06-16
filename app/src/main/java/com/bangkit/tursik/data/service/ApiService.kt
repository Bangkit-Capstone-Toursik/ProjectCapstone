package com.bangkit.tursik.data.service

import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/getAll")
    suspend fun getAllDestination()
    : DestinationAllResponse

    @GET("api/getByHighRating")
    suspend fun getDestinationPopular()
    : DestinationPopularResponse

    @GET("api/getByPrice/0.0")
    suspend fun getDestinationRecomended()
    : DestinationRecomededResponse

    @GET("api/getByCategory/Alam")
    suspend fun getDestinationAlam()
    : DestinationAlamResponse

    @GET("api/getByCategory/Pendidikan")
    suspend fun getDestinationPendidikan()
    : DestinationPendidikanResponse

    @GET("api/getByCategory/Religi")
    suspend fun getDestinationReligi()
    : DestinationReligiResponse

    @GET("api/getByCategory/Sejarah")
    suspend fun getDestinationSejarah()
    : DestinationSejarahResponse
}