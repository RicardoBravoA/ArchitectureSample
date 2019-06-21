package com.bcp.app.data.gateway.mapper

import com.bcp.app.data.local.model.EventTypeLocalModel
import com.bcp.app.domain.entity.EventType

class SystemMapper {

    fun toEntity(type: EventTypeLocalModel) = EventType(type.id, type.name)
}