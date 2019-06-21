package com.bcp.app.data.remote.model

import com.squareup.moshi.Json
import java.util.*

data class ReviewRemoteModel(
    @Json(name = "ConsumerName") var consumer: String,
    @Json(name = "Stars") var stars: Int,
    @Json(name = "CreatedAt") var date: Date,
    @Json(name = "Content") var content: String
)