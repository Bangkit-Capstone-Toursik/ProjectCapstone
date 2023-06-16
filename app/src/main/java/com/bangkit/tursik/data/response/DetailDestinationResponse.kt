package com.bangkit.tursik.data.response

import com.squareup.moshi.Json

data class DetailDestinationResponse(

	@field:Json(name="data")
	val data: Data? = null,

	@field:Json(name="status")
	val status: String? = null
)

data class ReviewsItem(

	@field:Json(name="author_name")
	val authorName: String? = null,

	@field:Json(name="profile_photo_url")
	val profilePhotoUrl: String? = null,

	@field:Json(name="original_language")
	val originalLanguage: String? = null,

	@field:Json(name="author_url")
	val authorUrl: String? = null,

	@field:Json(name="rating")
	val rating: Int? = null,

	@field:Json(name="language")
	val language: String? = null,

	@field:Json(name="text")
	val text: String? = null,

	@field:Json(name="time")
	val time: Int? = null,

	@field:Json(name="translated")
	val translated: Boolean? = null,

	@field:Json(name="relative_time_description")
	val relativeTimeDescription: String? = null
)

data class Data(

	@field:Json(name="types")
	val types: List<String?>? = null,

	@field:Json(name="reviews")
	val reviews: List<ReviewsItem?>? = null,

	@field:Json(name="placeData")
	val placeData: PlaceData? = null
)

data class PlaceData(

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
)
