package com.bcp.app.data.gateway

import com.bcp.app.data.gateway.mapper.EventTypeMapper
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.domain.entity.EventType
import com.bcp.app.domain.gateway.EventTypeGateway
import io.reactivex.Observable

class EventTypeGatewayImpl(private val eventTypeRepository: EventTypeRepository) : EventTypeGateway {

    private val mapper = EventTypeMapper()

    override fun getEventTypes(): Observable<List<EventType>> =

        eventTypeRepository.getAll()
            .doOnError { println("Event Type Error") }
            .map { it.map { mapper.toEntity(it) } }
}