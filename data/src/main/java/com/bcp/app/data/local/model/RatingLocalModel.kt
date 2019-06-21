package com.bcp.app.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rating")
data class RatingLocalModel(
    @PrimaryKey var event: Int,
    var average: Float
)