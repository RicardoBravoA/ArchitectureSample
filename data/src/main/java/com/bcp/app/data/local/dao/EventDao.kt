package com.bcp.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcp.app.data.local.model.EventLocalModel
import io.reactivex.Maybe

@Dao
interface EventDao {

    @Query("SELECT * FROM Event WHERE type = :type")
    fun findByType(type: Int): Maybe<List<EventLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg events: EventLocalModel)

    @Query("DELETE FROM Event WHERE type = :type")
    fun deleteByType(type: Int)

    @Query("SELECT * FROM Event WHERE id = :id")
    fun getById(id: Int): Maybe<EventLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: EventLocalModel)
}