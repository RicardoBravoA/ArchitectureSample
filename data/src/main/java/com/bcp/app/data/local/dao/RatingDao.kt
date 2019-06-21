package com.bcp.app.data.local.dao

import androidx.room.*
import com.bcp.app.data.local.model.RatingAndReviewLocalModel
import com.bcp.app.data.local.model.RatingLocalModel
import com.bcp.app.data.local.model.ReviewLocalModel
import io.reactivex.Maybe

@Dao
interface RatingDao {

    @Transaction // https://developer.android.com/reference/android/arch/persistence/room/Transaction.html
    @Query("SELECT * FROM Rating WHERE event = :event")
    fun findByEvent(event: Int): Maybe<RatingAndReviewLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(rating: RatingLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg reviews: ReviewLocalModel)

    @Transaction
    fun deleteByEvent(event: Int) {
        deleteReviewByEvent(event) // Delete reviews first to respect the constraints
        deleteRatingByEvent(event)
    }

    @Query("DELETE FROM Rating WHERE event = :event")
    fun deleteRatingByEvent(event: Int)

    @Query("DELETE FROM Review WHERE event = :event")
    fun deleteReviewByEvent(event: Int)
}