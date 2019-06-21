package com.bcp.app.data.gateway.mapper

import com.bcp.app.data.local.model.EventLocalModel
import com.bcp.app.data.local.model.RatingAndReviewLocalModel
import com.bcp.app.data.local.model.ReviewLocalModel
import com.bcp.app.data.local.model.VenueLocalModel
import com.bcp.app.domain.entity.Event
import com.bcp.app.domain.entity.Rating
import com.bcp.app.domain.entity.Review
import com.bcp.app.domain.entity.Venue

class InventoryMapper {

    fun toEntity(event: EventLocalModel) =
        Event(event.id, event.type, event.name, event.description, event.venue, event.runningTime, event.tagLine,
            event.image, event.thumbnail, event.url, event.currentPrice, event.offerPrice, event.minimumPrice)

    fun toEntity(venue: VenueLocalModel) = Venue(venue.id, venue.name)

    fun toEntity(rating: RatingAndReviewLocalModel) =
        Rating(rating.rating.event, rating.rating.average, toEntity(rating.reviews))

    fun toEntity(items: List<ReviewLocalModel>) =
        items.map { Review(it.consumer, it.stars, it.date, it.content) }
}