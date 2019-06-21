package com.bcp.app.data.repository.mapper

import com.bcp.app.data.local.model.VenueLocalModel
import com.bcp.app.data.remote.model.VenueRemoteModel

class VenueMapper {

    fun toLocal(venue: VenueRemoteModel) = VenueLocalModel(venue.id, venue.name ?: "")
}