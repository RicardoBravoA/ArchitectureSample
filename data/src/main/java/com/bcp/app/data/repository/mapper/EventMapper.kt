package com.bcp.app.data.repository.mapper

import com.bcp.app.data.local.model.EventLocalModel
import com.bcp.app.data.remote.model.EventRemoteModel

class EventMapper {

    fun toLocal(event: EventRemoteModel) =
        EventLocalModel(event.id, event.type, event.name, event.description, event.venue, event.runningTime, event.tagLine,
            event.image, event.thumbnail, event.url, event.currentPrice, event.offerPrice, event.minimumPrice)

    fun toLocal(items: List<EventRemoteModel>) = items.map { toLocal(it) }
}