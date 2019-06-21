package com.bcp.app.data.local

import com.bcp.app.data.local.dao.RatingDao
import com.bcp.app.data.local.model.RatingAndReviewLocalModel
import com.bcp.app.data.local.model.RatingLocalModel
import com.bcp.app.data.local.model.ReviewLocalModel
import io.reactivex.Observable

class RatingLocalDataSource(private val ratingDao: RatingDao) {

    fun findByEvent(event: Int): Observable<RatingAndReviewLocalModel> = ratingDao.findByEvent(event).toObservable()

    fun deleteByEvent(event: Int) {
        ratingDao.deleteByEvent(event)
    }

    fun insert(rating: RatingLocalModel, reviews: List<ReviewLocalModel>) {
        ratingDao.insert(rating)
        ratingDao.insertAll(*reviews.toTypedArray())
    }
}