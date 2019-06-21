package com.bcp.app.data.gateway.mapper

import com.bcp.app.data.local.model.EventLocalModel
import com.bcp.app.domain.entity.Event

class InventoryMapper {

    fun toEntity(event: EventLocalModel) =
        Event(event.id, event.type, event.name, event.description, event.venue, event.runningTime, event.tagLine,
            event.image, event.thumbnail, event.url, event.currentPrice, event.offerPrice, event.minimumPrice)
}