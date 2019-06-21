package com.bcp.app.domain.interactor

import com.bcp.app.domain.MissingUseCaseParameterException
import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.Rating
import com.bcp.app.domain.gateway.InventoryGateway
import io.reactivex.Observable

class RatingFindByEventUseCase(schedulers: Schedulers, private val inventoryGateway: InventoryGateway) :
    UseCase<Pair<Int, Boolean>, Rating>(schedulers) {

    override fun buildObservable(params: Pair<Int, Boolean>?): Observable<Rating> {
        if (params == null) throw MissingUseCaseParameterException(javaClass)
        val (event, refresh) = params
        return inventoryGateway.findRatingByEvent(event, refresh)
    }
}