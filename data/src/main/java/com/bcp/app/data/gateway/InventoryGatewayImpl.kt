package com.bcp.app.data.gateway

import com.bcp.app.data.gateway.mapper.InventoryMapper
import com.bcp.app.data.repository.EventRepository
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.data.repository.RatingRepository
import com.bcp.app.data.repository.VenueRepository
import com.bcp.app.domain.entity.Event
import com.bcp.app.domain.entity.Rating
import com.bcp.app.domain.entity.Venue
import com.bcp.app.domain.gateway.InventoryGateway
import io.reactivex.Observable

class InventoryGatewayImpl(
    private val eventTypeRepository: EventTypeRepository,
    private val eventRepository: EventRepository,
    private val venueRepository: VenueRepository,
    private val ratingRepository: RatingRepository) : InventoryGateway {

    private val mapper = InventoryMapper()

    override fun findEventsByType(type: Int, refresh: Boolean): Observable<List<Event>> =

        eventRepository.findByType(type, refresh)
            .doOnError { println("Event By Type($type) Error") }
            .map { it.map { mapper.toEntity(it) } }

    override fun getVenueById(id: Int): Observable<Venue> =

        venueRepository.getById(id)
            .doOnError { println("Venue By Id($id) Error") }
            .map { mapper.toEntity(it) }

    override fun getEventById(id: Int): Observable<Event> =

        eventRepository.getById(id)
            .doOnError { println("Event By Id($id) Error") }
            .flatMap { event ->
                eventTypeRepository.getById(event.type)
                    .doOnError { println("Event Type By Id(${event.type}) Error") }
                    .map { mapper.toEntity(event) }
            }

    override fun findRatingByEvent(event: Int, refresh: Boolean): Observable<Rating> =

        ratingRepository.findByEvent(event, refresh)
            .doOnError { println("Rating By Event($event) Error") }
            .map { mapper.toEntity(it) }
}