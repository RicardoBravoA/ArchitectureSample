package com.bcp.app.data.repository

import com.bcp.app.data.local.UserLocalDataSource
import com.bcp.app.data.local.model.UserLocalModel
import com.bcp.app.data.remote.UserRemoteDataSource
import com.bcp.app.data.repository.mapper.UserMapper
import io.reactivex.Observable

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userMapper: UserMapper) {

    fun getUser(): Observable<UserLocalModel> {

        val local = userLocalDataSource.getUser()

        val remote = userRemoteDataSource.getUser()
            .map { userMapper.remoteToLocal(it) }
            .doOnNext { userLocalDataSource.insertUser(it) }

        return Observable.concat(local, remote)
            .firstElement()
            .toObservable()
    }
}

