package com.bcp.app.domain.interactor

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.BaseUseCase
import com.bcp.app.domain.entity.UserEntity
import com.bcp.app.domain.gateway.UserGateway
import io.reactivex.Single

class UserUseCase(schedulers: Schedulers, private val userGateway: UserGateway) :
    BaseUseCase<Void, UserEntity>(schedulers) {

    override fun buildSingle(params: Void?): Single<UserEntity> {
        return userGateway.getUserData()
    }
}