package com.bcp.app.data.remote.api

import com.bcp.app.data.remote.model.UserRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface GitHubService {

    @GET("/users/ricardobravoa")
    fun getUser(): Single<UserRemoteModel>

}