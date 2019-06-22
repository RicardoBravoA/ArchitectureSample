package com.bcp.app.data.local

import com.bcp.app.data.local.dao.UserDao
import com.bcp.app.data.local.model.UserLocalModel
import io.reactivex.Maybe
import io.reactivex.Single

class UserLocalDataSource(private val userDao: UserDao) {

    fun getUser(): Maybe<UserLocalModel> = userDao.getUser()

    fun insertUser(userLocalModel: UserLocalModel) = userDao.insertUser(userLocalModel)
}