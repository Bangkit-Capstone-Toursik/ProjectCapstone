package com.bangkit.tursik.other

import android.view.View
import com.bangkit.tursik.data.entity.WishlistEntity

interface ItemClickListener {
    fun onItemClick(data: String)
    fun onItemMenuClick(view: View, user: WishlistEntity)
}