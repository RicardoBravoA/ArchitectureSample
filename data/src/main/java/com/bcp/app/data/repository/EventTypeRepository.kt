package com.bcp.app.data.repository

import com.bcp.app.data.local.EventTypeLocalDataSource
import com.bcp.app.data.local.model.EventTypeLocalModel
import com.bcp.app.data.remote.EventTypeRemoteDataSource
import com.bcp.app.data.repository.mapper.EventTypeMapper
import io.reactivex.Observable

class EventTypeRepository(
    private val eventTypeLocalDataSource: EventTypeLocalDataSource,
    private val eventTypeRemoteDataSource: EventTypeRemoteDataSource,
    private val eventTypeMapper: EventTypeMapper) {

    fun getAll(): Observable<List<EventTypeLocalModel>> {

        val local = eventTypeLocalDataSource.getAll()
            .filter { !it.isEmpty() }

        val remote = eventTypeRemoteDataSource.getAll()
            .map { eventTypeMapper.toLocal(it) }
            .doOnNext { eventTypeLocalDataSource.insertAll(it) }

        return Observable.concat(local, remote)
            .firstElement()
            .toObservable()
    }

    fun getById(id: Int): Observable<EventTypeLocalModel> = eventTypeLocalDataSource.getById(id)
}

