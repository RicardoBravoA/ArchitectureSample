package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.Event
import com.bcp.app.domain.gateway.InventoryGateway
import io.reactivex.Observable

class EventGetByIdUseCase(schedulers: Schedulers, private val inventoryGateway: InventoryGateway) :
    UseCase<Int, Event>(schedulers) {

    override fun buildObservable(params: Int?): Observable<Event> {
        return inventoryGateway.getEventById(params!!)
    }
}