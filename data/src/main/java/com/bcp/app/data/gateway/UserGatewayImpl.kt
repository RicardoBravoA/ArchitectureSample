package com.bcp.app.data.gateway

import com.bcp.app.data.gateway.mapper.UserGatewayMapper
import com.bcp.app.data.repository.UserRepository
import com.bcp.app.domain.entity.UserEntity
import com.bcp.app.domain.gateway.UserGateway
import io.reactivex.Single

class UserGatewayImpl(private val userRepository: UserRepository) : UserGateway {

    private val mapper = UserGatewayMapper()

    override fun getUserData(): Single<UserEntity> =

        userRepository.getUser()
            .map { mapper.toLocalEntity(it) }
            .doOnError { println("UserGateway Error") }
}