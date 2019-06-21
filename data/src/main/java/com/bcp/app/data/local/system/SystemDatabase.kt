package com.bcp.app.data.local.system

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.dao.VenueDao
import com.bcp.app.data.local.model.EventTypeLocalModel
import com.bcp.app.data.local.model.VenueLocalModel
import com.bcp.app.data.local.util.Converters

@Database(entities = [EventTypeLocalModel::class, VenueLocalModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SystemDatabase : RoomDatabase() {

    abstract fun eventTypeDao(): EventTypeDao

    abstract fun venueDao(): VenueDao

    companion object {
        fun newInstance(context: Context): SystemDatabase {
            return Room.databaseBuilder(context, SystemDatabase::class.java, "theatre-system.db").build()
        }
    }
}