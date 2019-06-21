package com.bcp.app.data.local

import com.bcp.app.data.local.dao.VenueDao
import com.bcp.app.data.local.model.VenueLocalModel
import io.reactivex.Observable

class VenueLocalDataSource(private val venueDao: VenueDao) {

    fun getById(id: Int): Observable<VenueLocalModel> = venueDao.getById(id).toObservable()

    fun insert(venue: VenueLocalModel) = venueDao.insert(venue)
}