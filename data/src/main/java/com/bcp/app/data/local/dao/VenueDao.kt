package com.bcp.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcp.app.data.local.model.VenueLocalModel
import io.reactivex.Maybe

@Dao
interface VenueDao {

    @Query("SELECT * FROM Venue WHERE id = :id")
    fun getById(id: Int): Maybe<VenueLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: VenueLocalModel)
}