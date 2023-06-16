package com.bangkit.tursik

data class VisitorReview(
    val name: String,
    val rating: Float,
    val review: String,
    val date: String
)

val visitorReviews = listOf(
    VisitorReview(
        name = "John Doe",
        rating = 4.5f,
        review = "Great experience! The place was beautiful and the staff was friendly.",
        date = "2023-06-15"
    ),
    VisitorReview(
        name = "Jane Smith",
        rating = 5.0f,
        review = "Absolutely loved it! The scenery was breathtaking and the activities were fun.",
        date = "2023-06-14"
    ),
    VisitorReview(
        name = "Michael Johnson",
        rating = 3.8f,
        review = "It was okay. The place was crowded and the prices were a bit high.",
        date = "2023-06-13"
    )
)
