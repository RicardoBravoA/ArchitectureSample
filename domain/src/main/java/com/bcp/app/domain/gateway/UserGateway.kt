package com.bcp.app.domain.gateway

import com.bcp.app.domain.entity.UserEntity
import io.reactivex.Observable

interface UserGateway {

    fun getUserData(): Observable<UserEntity>
}