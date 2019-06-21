package com.bcp.app.data.repository

import com.bcp.app.data.local.VenueLocalDataSource
import com.bcp.app.data.local.model.VenueLocalModel
import com.bcp.app.data.remote.VenueRemoteDataSource
import com.bcp.app.data.repository.mapper.VenueMapper
import io.reactivex.Observable

class VenueRepository(
    private val venueLocalDataSource: VenueLocalDataSource,
    private val venueRemoteDataSource: VenueRemoteDataSource,
    private val venueMapper: VenueMapper) {

    fun getById(id: Int): Observable<VenueLocalModel> {

        val local = venueLocalDataSource.getById(id)

        val remote = venueRemoteDataSource.getById(id)
            .map { venueMapper.toLocal(it) }
            .doOnNext { venueLocalDataSource.insert(it) }

        return Observable.concat(local, remote)
            .firstElement()
            .toObservable()
    }
}