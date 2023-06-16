package com.bangkit.tursik.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class DestinationReligiResponse(

	@field:Json(name="data")
	val data: List<DataItemReligi?>? = null,

	@field:Json(name="status")
	val status: String? = null
)
@Parcelize
data class DataItemReligi(

	@field:Json(name="Price")
	val price: String? = null,

	@field:Json(name="Rating")
	val rating: String? = null,

	@field:Json(name="Province")
	val province: String? = null,

	@field:Json(name="Name")
	val name: String? = null
):Parcelable
