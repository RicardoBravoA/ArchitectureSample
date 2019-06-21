package com.bcp.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcp.app.data.local.model.UserLocalModel
import io.reactivex.Maybe

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getUser(): Maybe<UserLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg users: UserLocalModel)
}