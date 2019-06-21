package com.bcp.app.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Venue")
data class VenueLocalModel(
    @PrimaryKey var id: Int,
    var name: String)