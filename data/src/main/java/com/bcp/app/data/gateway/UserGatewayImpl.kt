package com.bcp.app.data.gateway

import com.bcp.app.data.gateway.mapper.UserMapper
import com.bcp.app.data.repository.UserRepository
import com.bcp.app.domain.entity.UserEntity
import com.bcp.app.domain.gateway.UserGateway
import io.reactivex.Observable

class UserGatewayImpl(private val userRepository: UserRepository) : UserGateway {

    private val mapper = UserMapper()

    override fun getUserData(): Observable<UserEntity> =

        userRepository.getUser()
            .doOnError { println("UserGateway Error") }
            .map { mapper.toLocalEntity(it) }
}