package com.bangkit.tursik.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class DestinationAllResponse(

	@field:Json(name="data")
	val data: List<DataItemAll?>? = null,

	@field:Json(name="status")
	val status: String? = null
)
@Parcelize
data class DataItemAll(

	@field:Json(name="Regency")
	val regency: String? = null,

	@field:Json(name="Category")
	val category: String? = null,

	@field:Json(name="Price")
	val price: String? = null,

	@field:Json(name="Rating")
	val rating: String? = null,

	@field:Json(name="Province")
	val province: String? = null,

	@field:Json(name="Name")
	val name: String? = null
): Parcelable
