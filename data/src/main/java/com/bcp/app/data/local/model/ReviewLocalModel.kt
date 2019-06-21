package com.bcp.app.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.*

@Entity(tableName = "Review",
    primaryKeys = ["event", "consumer"],
    foreignKeys = [ForeignKey(entity = RatingLocalModel::class, parentColumns = ["event"], childColumns = ["event"])]
)
data class ReviewLocalModel(
    var event: Int,
    var consumer: String,
    var stars: Int,
    var date: Date,
    var content: String
)