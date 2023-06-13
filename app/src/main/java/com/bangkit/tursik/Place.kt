package com.bangkit.tursik

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Place(
    val photo: Int,
    val name: String,
    val price: String,
    val location: String,
    val rating: Float
):Parcelable

fun getDummyPlaceList(): List<Place> {
    val placeList = ArrayList<Place>()

    placeList.add(
        Place(
            R.drawable.place,
            "Tempat A",
            "$100",
            "Lokasi A",
            4.5f
        )
    )

    placeList.add(
        Place(
            R.drawable.place,
            "Tempat B",
            "$200",
            "Lokasi B",
            4.0f
        )
    )

    placeList.add(
        Place(
            R.drawable.place,
            "Tempat C",
            "$150",
            "Lokasi C",
            4.2f
        )
    )

    // Tambahkan tempat lainnya sesuai kebutuhan

    return placeList
}