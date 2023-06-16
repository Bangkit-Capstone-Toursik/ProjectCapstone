package com.bangkit.tursik.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.databinding.ItemListPlaceBinding
import com.bangkit.tursik.other.ItemClickListener


class WishlistAdapter(private val listener: ItemClickListener) :
    ListAdapter<WishlistEntity, WishlistAdapter.UserViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder.create(parent = parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(userData = getItem(position), listener = listener)
    }

    class UserViewHolder(private val binding: ItemListPlaceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindData(userData: WishlistEntity, listener: ItemClickListener) {
            binding.root.setOnClickListener { listener.onItemClick(userData.login ?: "") }
            binding.tvPlace.text = userData.login
            binding.tvLocation.text = userData.name
            binding.tvPrice.text = userData.price.toString()


            }
        companion object {
            fun create(parent: ViewGroup): WishlistAdapter.UserViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemListPlaceBinding.inflate(inflater, parent, false)
                return WishlistAdapter.UserViewHolder(binding)
            }
        }
    }





    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<WishlistEntity>() {
            override fun areItemsTheSame(
                oldItem: WishlistEntity,
                newItem: WishlistEntity
            ): Boolean =
                oldItem === newItem

            override fun areContentsTheSame(
                oldItem: WishlistEntity,
                newItem: WishlistEntity
            )
                    : Boolean = oldItem.name == newItem.name
        }
    }
}