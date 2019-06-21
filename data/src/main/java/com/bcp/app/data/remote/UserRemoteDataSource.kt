package com.bcp.app.data.remote

import com.bcp.app.data.remote.api.GitHubService
import com.bcp.app.data.remote.model.UserRemoteModel
import io.reactivex.Observable

class UserRemoteDataSource(private val gitHubService: GitHubService) {

    fun getUser(): Observable<UserRemoteModel> = gitHubService.getUser()
}