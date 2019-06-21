package com.bcp.app.data.remote.api

import com.bcp.app.data.remote.model.EventTypeRemoteModel
import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Observable
import retrofit2.http.GET

interface TheatreService {

    @GET("System/EventTypes")
    @Wrapped(path = ["EventTypes"])
    fun getEventTypes(): Observable<List<EventTypeRemoteModel>>

}