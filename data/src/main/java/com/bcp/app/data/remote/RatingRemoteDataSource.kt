package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.remote.model.RatingRemoteModel
import io.reactivex.Observable

class RatingRemoteDataSource(private val theatreService: TheatreService) {

    fun findByEvent(event: Int): Observable<RatingRemoteModel> = theatreService.getEventRating(event)
}