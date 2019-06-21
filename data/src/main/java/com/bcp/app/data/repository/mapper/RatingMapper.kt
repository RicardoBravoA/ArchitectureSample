package com.bcp.app.data.repository.mapper

import com.bcp.app.data.local.model.RatingAndReviewLocalModel
import com.bcp.app.data.local.model.RatingLocalModel
import com.bcp.app.data.local.model.ReviewLocalModel
import com.bcp.app.data.remote.model.RatingRemoteModel
import com.bcp.app.data.remote.model.ReviewRemoteModel

class RatingMapper {

    fun toLocal(event: Int, rating: RatingRemoteModel): RatingAndReviewLocalModel {
        val ratingAndReviewLocalModel = RatingAndReviewLocalModel(RatingLocalModel(event, rating.average))
        ratingAndReviewLocalModel.reviews = toLocal(event, rating.reviews)
        return ratingAndReviewLocalModel
    }

    fun toLocal(event: Int, reviews: List<ReviewRemoteModel>) =
        reviews.map { ReviewLocalModel(event, it.consumer, it.stars, it.date, it.content) }
}