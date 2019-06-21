package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.UseCase
import com.bcp.app.domain.entity.UserEntity
import com.bcp.app.domain.gateway.UserGateway
import io.reactivex.Observable

class UserUseCase(schedulers: Schedulers, private val userGateway: UserGateway) :
    UseCase<Void, UserEntity>(schedulers) {

    override fun buildObservable(params: Void?): Observable<UserEntity> {
        return userGateway.getUserData()
    }
}