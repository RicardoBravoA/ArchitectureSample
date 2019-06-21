package com.bcp.app.data.remote.model

import com.squareup.moshi.Json

data class VenueRemoteModel(
    @Json(name = "VenueId") var id: Int,
    @Json(name = "Name") var name: String?
)