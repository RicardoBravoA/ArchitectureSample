package com.bcp.app.data.remote.model

import com.squareup.moshi.Json

data class RatingRemoteModel(
    @Json(name = "AverageRating") var average: Float,
    @Json(name = "Reviews") var reviews: List<ReviewRemoteModel>
)