package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.EventType
import com.bcp.app.domain.gateway.EventTypeGateway
import io.reactivex.Observable

class EventTypeGetAllUseCase(schedulers: Schedulers, private val eventTypeGateway: EventTypeGateway) :
    UseCase<Void, List<EventType>>(schedulers) {

    override fun buildObservable(params: Void?): Observable<List<EventType>> {
        return eventTypeGateway.getEventTypes()
    }
}