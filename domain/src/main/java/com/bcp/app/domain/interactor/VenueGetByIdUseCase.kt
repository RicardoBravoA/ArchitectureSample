package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.Venue
import com.bcp.app.domain.gateway.InventoryGateway
import io.reactivex.Observable

class VenueGetByIdUseCase(schedulers: Schedulers, private val inventoryGateway: InventoryGateway) :
    UseCase<Int, Venue>(schedulers) {

    override fun buildObservable(params: Int?): Observable<Venue> {
        return inventoryGateway.getVenueById(params!!)
    }
}