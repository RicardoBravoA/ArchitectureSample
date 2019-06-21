package com.bcp.app.data.local.system

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.model.EventTypeLocalModel
import com.bcp.app.data.local.util.Converters

@Database(entities = [EventTypeLocalModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class EventTypeDatabase : RoomDatabase() {

    abstract fun eventTypeDao(): EventTypeDao

    companion object {
        fun newInstance(context: Context): EventTypeDatabase {
            return Room.databaseBuilder(context, EventTypeDatabase::class.java, "theatre-system.db").build()
        }
    }
}