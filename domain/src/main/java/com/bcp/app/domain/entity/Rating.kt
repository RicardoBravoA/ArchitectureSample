package com.bcp.app.domain.entity

data class Rating(
    val event: Int,
    val rating: Float,
    val reviews: List<Review>)