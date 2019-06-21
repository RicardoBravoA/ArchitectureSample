package com.bcp.app.domain.gateway

import com.bcp.app.domain.entity.Event
import io.reactivex.Observable

interface InventoryGateway {

    fun findEventsByType(type: Int, refresh: Boolean = false): Observable<List<Event>>

    fun getEventById(id: Int): Observable<Event>
}