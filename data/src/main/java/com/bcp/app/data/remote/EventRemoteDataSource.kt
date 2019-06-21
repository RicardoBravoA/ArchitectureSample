package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.remote.model.EventRemoteModel
import io.reactivex.Observable

class EventRemoteDataSource(private val theatreService: TheatreService) {

    fun findByType(type: Int): Observable<List<EventRemoteModel>> = theatreService.getEvents(type)

    fun getById(id: Int): Observable<EventRemoteModel> = theatreService.getEvent(id)
}