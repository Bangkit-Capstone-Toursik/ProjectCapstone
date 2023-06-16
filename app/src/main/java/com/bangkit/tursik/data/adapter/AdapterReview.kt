package com.bangkit.tursik.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.R
import com.bangkit.tursik.VisitorReview

class AdapterReview (var visitorReviews: List<VisitorReview>) :
    RecyclerView.Adapter<AdapterReview.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.textName)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val txtReview: TextView = itemView.findViewById(R.id.textReview)
        private val txtDate: TextView = itemView.findViewById(R.id.textDate)

        fun bind(review: VisitorReview) {
            txtName.text = review.name
            ratingBar.rating = review.rating
            txtReview.text = review.review
            txtDate.text = review.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val review = visitorReviews[position]
        holder.bind(review)
    }

    override fun getItemCount(): Int {
        return visitorReviews.size
    }
}