package com.bcp.app.data.repository

import com.bcp.app.data.local.RatingLocalDataSource
import com.bcp.app.data.local.model.RatingAndReviewLocalModel
import com.bcp.app.data.remote.RatingRemoteDataSource
import com.bcp.app.data.repository.mapper.RatingMapper
import io.reactivex.Observable

class RatingRepository(
    private val ratingLocalDataSource: RatingLocalDataSource,
    private val ratingRemoteDataSource: RatingRemoteDataSource,
    private val ratingMapper: RatingMapper) {

    fun findByEvent(event: Int, refresh: Boolean = false): Observable<RatingAndReviewLocalModel> {

        val local = ratingLocalDataSource.findByEvent(event)

        val remote = ratingRemoteDataSource.findByEvent(event)
            .map { ratingMapper.toLocal(event, it) }
            .doOnNext { ratingLocalDataSource.insert(it.rating, it.reviews) }

        return Observable.just(refresh)
            .doOnNext { if (it) ratingLocalDataSource.deleteByEvent(event) }
            .flatMap {
                Observable.concat(local, remote)
                    .firstElement()
                    .toObservable()
            }
    }
}
