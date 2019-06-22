package com.bcp.app.data.repository

import com.bcp.app.data.local.UserLocalDataSource
import com.bcp.app.data.local.model.UserLocalModel
import com.bcp.app.data.remote.UserRemoteDataSource
import com.bcp.app.data.repository.mapper.UserMapper
import io.reactivex.Maybe
import io.reactivex.Single

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userMapper: UserMapper
) {

    fun getUser(): Single<UserLocalModel> {

        val local = userLocalDataSource.getUser()

        val remote = userRemoteDataSource.getUser()
            .map { userMapper.remoteToLocal(it) }
            .doOnSuccess {
                userLocalDataSource.insertUser(it)
            }

        return Maybe.concat(local, remote.toMaybe())
            .firstElement()
            .toSingle()
    }
}

