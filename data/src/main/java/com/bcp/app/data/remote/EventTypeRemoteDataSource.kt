package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.remote.model.EventTypeRemoteModel
import io.reactivex.Observable

class EventTypeRemoteDataSource(private val theatreService: TheatreService) {

    fun getAll(): Observable<List<EventTypeRemoteModel>> = theatreService.getEventTypes()
}