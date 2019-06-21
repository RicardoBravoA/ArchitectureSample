package com.bcp.app.data.local.inventory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcp.app.data.local.dao.EventDao
import com.bcp.app.data.local.model.EventLocalModel
import com.bcp.app.data.local.util.Converters

@Database(entities = [EventLocalModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        fun newInstance(context: Context): InventoryDatabase {
            return Room.inMemoryDatabaseBuilder(context, InventoryDatabase::class.java).build()
        }
    }
}