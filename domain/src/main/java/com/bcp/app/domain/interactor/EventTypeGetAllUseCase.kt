package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.EventType
import com.bcp.app.domain.gateway.SystemGateway
import io.reactivex.Observable

class EventTypeGetAllUseCase(schedulers: Schedulers, private val systemGateway: SystemGateway) :
    UseCase<Void, List<EventType>>(schedulers) {

    override fun buildObservable(params: Void?): Observable<List<EventType>> {
        return systemGateway.getEventTypes()
    }
}