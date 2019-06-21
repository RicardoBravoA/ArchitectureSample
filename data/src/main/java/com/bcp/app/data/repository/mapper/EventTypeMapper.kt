package com.bcp.app.data.repository.mapper

import com.bcp.app.data.local.model.EventTypeLocalModel
import com.bcp.app.data.remote.model.EventTypeRemoteModel

class EventTypeMapper {

    fun toLocal(eventType: EventTypeRemoteModel) = EventTypeLocalModel(eventType.id, eventType.name)

    fun toLocal(items: List<EventTypeRemoteModel>) = items.map { toLocal(it) }
}