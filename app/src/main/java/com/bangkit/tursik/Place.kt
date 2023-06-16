package com.bangkit.tursik

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Place(
    val name: String,
    val price: String,
    val province: String,
    val rating: Float
):Parcelable

