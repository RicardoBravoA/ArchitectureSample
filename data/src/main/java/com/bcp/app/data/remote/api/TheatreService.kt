package com.bcp.app.data.remote.api

import com.bcp.app.data.remote.model.EventRemoteModel
import com.bcp.app.data.remote.model.EventTypeRemoteModel
import com.bcp.app.data.remote.model.RatingRemoteModel
import com.bcp.app.data.remote.model.VenueRemoteModel
import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheatreService {

    @GET("System/EventTypes")
    @Wrapped(path = ["EventTypes"])
    fun getEventTypes(): Observable<List<EventTypeRemoteModel>>

    @GET("Events")
    @Wrapped(path = ["Events"])
    fun getEvents(@Query("type") type: Int): Observable<List<EventRemoteModel>>

    @GET("Events/{id}")
    @Wrapped(path = ["Event"])
    fun getEvent(@Path("id") id: Int): Observable<EventRemoteModel>

    @GET("Venues/{id}")
    @Wrapped(path = ["Venue"])
    fun getVenue(@Path("id") id: Int): Observable<VenueRemoteModel>

    @GET("Events/{event}/Reviews")
    fun getEventRating(@Path("event") event: Int): Observable<RatingRemoteModel>

}