package com.bcp.app.domain.entity

data class Event(
    val id: Int,
    val type: Int,
    val name: String,
    val description: String?,
    val venue: Int,
    val runningTime: String?,
    val tagLine: String?,
    val image: String?,
    val thumbnail: String?,
    val url: String?,
    val currentPrice: Float,
    val offerPrice: Float,
    val minimumPrice: Float)