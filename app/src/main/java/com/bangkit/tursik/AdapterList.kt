package com.bangkit.tursik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterList(private val itemList: List<Place>) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewPlace: ImageView = itemView.findViewById(R.id.iv_place)
        val textViewPlaceName: TextView = itemView.findViewById(R.id.tv_place)
        val textViewPlacePrice: TextView = itemView.findViewById(R.id.tv_price)
        val textViewPlaceLocation: TextView = itemView.findViewById(R.id.tv_location)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val place = itemList[position]
                    onItemClickListener?.onItemClick(place)
                }
            }
        }

        fun bind(place: Place) {
            textViewPlaceName.text = place.name
            textViewPlacePrice.text = place.price
            textViewPlaceLocation.text = place.location

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_place, parent, false)
        return ViewHolder(view)
    }

    interface OnItemClickListener {
        fun onItemClick(place: Place)
    }

    // Metode untuk mengatur listener onItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = itemList[position]

        holder.bind(place)

        holder.imageViewPlace.setImageResource(place.photo)
        holder.textViewPlaceName.text = place.name
        holder.textViewPlacePrice.text = place.price
        holder.textViewPlaceLocation.text = place.location
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}