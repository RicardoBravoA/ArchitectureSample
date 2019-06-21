package com.bcp.app.domain.gateway

import com.bcp.app.domain.entity.EventType
import io.reactivex.Observable

interface EventTypeGateway {

    fun getEventTypes(): Observable<List<EventType>>
}