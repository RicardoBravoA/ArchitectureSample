package com.bcp.app.data.local.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcp.app.data.local.dao.UserDao
import com.bcp.app.data.local.model.UserLocalModel
import com.bcp.app.data.local.util.Converters

@Database(entities = [UserLocalModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun eventTypeDao(): UserDao

    companion object {
        fun newInstance(context: Context): UserDatabase {
            return Room.databaseBuilder(context, UserDatabase::class.java, "github.db").build()
        }
    }
}