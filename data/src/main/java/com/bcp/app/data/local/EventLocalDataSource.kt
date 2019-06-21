package com.bcp.app.data.local

import com.bcp.app.data.local.dao.EventDao
import com.bcp.app.data.local.model.EventLocalModel
import io.reactivex.Observable

class EventLocalDataSource(private val eventDao: EventDao) {

    fun findByType(type: Int): Observable<List<EventLocalModel>> = eventDao.findByType(type).toObservable()

    fun deleteByType(type: Int) = eventDao.deleteByType(type)

    fun getById(id: Int): Observable<EventLocalModel> = eventDao.getById(id).toObservable()

    fun insertAll(events: List<EventLocalModel>) = eventDao.insertAll(*events.toTypedArray())

    fun insert(event: EventLocalModel) = eventDao.insert(event)
}