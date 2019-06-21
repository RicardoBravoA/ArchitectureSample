package com.bcp.app.data.local

import com.bcp.app.data.local.dao.UserDao
import com.bcp.app.data.local.model.UserLocalModel
import io.reactivex.Observable

class UserLocalDataSource(private val userDao: UserDao) {

    fun getUser(): Observable<UserLocalModel> = userDao.getUser().toObservable()

    fun insertUser(userLocalModel: UserLocalModel) = userDao.insertUser(userLocalModel)
}