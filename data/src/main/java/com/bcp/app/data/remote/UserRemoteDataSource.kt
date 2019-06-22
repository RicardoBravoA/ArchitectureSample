package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.GitHubService
import com.bcp.app.data.remote.model.UserRemoteModel
import io.reactivex.Single

class UserRemoteDataSource(private val gitHubService: GitHubService) {

    fun getUser(): Single<UserRemoteModel> = gitHubService.getUser()
}