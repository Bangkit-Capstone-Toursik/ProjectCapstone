package com.bangkit.tursik.other


import com.bangkit.tursik.data.response.DataItemAll
import com.squareup.moshi.Json

data class SearchUserResult(
    @field:Json(name = "place")
    val result: List<DataItemAll>? = null
)
