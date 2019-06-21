package com.bcp.app.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class RatingAndReviewLocalModel(@Embedded var rating: RatingLocalModel) {

    @Relation(parentColumn = "event", entityColumn = "event", entity = ReviewLocalModel::class)
    lateinit var reviews: List<ReviewLocalModel>
}