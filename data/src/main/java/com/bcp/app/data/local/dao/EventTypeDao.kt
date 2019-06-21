package com.bcp.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcp.app.data.local.model.EventTypeLocalModel
import io.reactivex.Maybe

@Dao
interface EventTypeDao {

    @Query("SELECT * FROM EventType WHERE id = :id")
    fun getById(id: Int): Maybe<EventTypeLocalModel>

    @Query("SELECT * FROM EventType")
    fun getAll(): Maybe<List<EventTypeLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg eventTypes: EventTypeLocalModel)
}