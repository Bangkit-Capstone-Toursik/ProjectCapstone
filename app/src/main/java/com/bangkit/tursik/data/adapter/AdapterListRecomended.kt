package com.bangkit.tursik.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.R
import com.bangkit.tursik.data.response.DataItemDestinationRecomended

class AdapterListRecomended(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<DataItemDestinationRecomended, AdapterListRecomended.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_place,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewPlaceName: TextView = itemView.findViewById(R.id.tv_place)
        private val textViewPlacePrice: TextView = itemView.findViewById(R.id.tv_price)
        private val textViewPlaceRating: TextView = itemView.findViewById(R.id.tv_rating)
        private val textViewPlaceLocation: TextView = itemView.findViewById(R.id.tv_location)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val place = getItem(position)
                    onItemClickListener.onItemClick(place)
                }
            }
        }

        fun bind(place: DataItemDestinationRecomended) {
            textViewPlaceName.text = place.name
            textViewPlacePrice.text = place.price
            textViewPlaceLocation.text = place.province
            textViewPlaceRating.text = place.rating
        }
    }

    interface OnItemClickListener {
        fun onItemClick(place: DataItemDestinationRecomended)
    }

    private class DiffCallback : DiffUtil.ItemCallback<DataItemDestinationRecomended>() {
        override fun areItemsTheSame(oldItem: DataItemDestinationRecomended, newItem: DataItemDestinationRecomended): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataItemDestinationRecomended, newItem: DataItemDestinationRecomended): Boolean {
            return oldItem == newItem
        }
    }
}