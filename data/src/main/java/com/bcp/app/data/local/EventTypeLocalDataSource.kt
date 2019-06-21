package com.bcp.app.data.local

import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.model.EventTypeLocalModel
import io.reactivex.Observable

class EventTypeLocalDataSource(private val eventTypeDao: EventTypeDao) {

    fun getAll(): Observable<List<EventTypeLocalModel>> = eventTypeDao.getAll().toObservable()

    fun getById(id: Int): Observable<EventTypeLocalModel> = eventTypeDao.getById(id).toObservable()

    fun insertAll(events: List<EventTypeLocalModel>) = eventTypeDao.insertAll(*events.toTypedArray())
}