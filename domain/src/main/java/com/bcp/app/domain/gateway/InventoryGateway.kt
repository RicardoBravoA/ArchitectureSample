package com.bcp.app.domain.gateway

import com.bcp.app.domain.entity.Event
import com.bcp.app.domain.entity.Rating
import com.bcp.app.domain.entity.Venue
import io.reactivex.Observable

interface InventoryGateway {

    fun findEventsByType(type: Int, refresh: Boolean = false): Observable<List<Event>>

    fun getVenueById(id: Int): Observable<Venue>

    fun getEventById(id: Int): Observable<Event>

    fun findRatingByEvent(event: Int, refresh: Boolean = false): Observable<Rating>
}