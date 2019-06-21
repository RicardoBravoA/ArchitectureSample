package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.remote.model.VenueRemoteModel
import io.reactivex.Observable

class VenueRemoteDataSource(private val theatreService: TheatreService) {

    fun getById(id: Int): Observable<VenueRemoteModel> = theatreService.getVenue(id)
}