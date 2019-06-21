package com.bcp.app.domain.interactor

import com.bcp.app.domain.MissingUseCaseParameterException
import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.Event
import com.bcp.app.domain.gateway.InventoryGateway
import io.reactivex.Observable

class EventFindByTypeUseCase(schedulers: Schedulers, private val inventoryGateway: InventoryGateway) :
    UseCase<Pair<Int, Boolean>, List<Event>>(schedulers) {

    override fun buildObservable(params: Pair<Int, Boolean>?): Observable<List<Event>> {
        if (params == null) throw MissingUseCaseParameterException(javaClass)
        val (type, refresh) = params
        return inventoryGateway.findEventsByType(type, refresh)
    }
}