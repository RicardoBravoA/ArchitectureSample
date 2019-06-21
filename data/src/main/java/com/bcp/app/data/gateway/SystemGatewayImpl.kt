package com.bcp.app.data.gateway

import com.bcp.app.data.gateway.mapper.SystemMapper
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.domain.entity.EventType
import com.bcp.app.domain.gateway.SystemGateway
import io.reactivex.Observable

class SystemGatewayImpl(private val eventTypeRepository: EventTypeRepository) : SystemGateway {

    private val mapper = SystemMapper()

    override fun getEventTypes(): Observable<List<EventType>> =

        eventTypeRepository.getAll()
            .doOnError { println("Event Type Error") }
            .map { it.map { mapper.toEntity(it) } }
}