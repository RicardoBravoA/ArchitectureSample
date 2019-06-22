package com.bcp.app.domain.gateway

import com.bcp.app.domain.entity.UserEntity
import io.reactivex.Single

interface UserGateway {

    fun getUserData(): Single<UserEntity>
}