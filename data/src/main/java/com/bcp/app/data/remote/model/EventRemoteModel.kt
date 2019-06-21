package com.bcp.app.data.remote.model

import com.squareup.moshi.Json

data class EventRemoteModel(
    @Json(name = "EventId") var id: Int,
    @Json(name = "EventType") var type: Int,
    @Json(name = "Name") var name: String,
    @Json(name = "Description") var description: String?,
    @Json(name = "VenueId") var venue: Int,
    @Json(name = "RunningTime") var runningTime: String?,
    @Json(name = "TagLine") var tagLine: String?,
    @Json(name = "MainImageUrl") var image: String?,
    @Json(name = "SmallImageUrl") var thumbnail: String?,
    @Json(name = "EventDetailUrl") var url: String?,
    @Json(name = "CurrentPrice") var currentPrice: Float,
    @Json(name = "OfferPrice") var offerPrice: Float,
    @Json(name = "EventMinimumPrice") var minimumPrice: Float
)