package com.bcp.app.data.remote.api

import com.bcp.app.data.BuildConfig
import com.bcp.app.data.remote.model.UserRemoteModel
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GitHubApi(baseUrl: String) : GitHubService {

    private val service: GitHubService

    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) BODY else NONE

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

        val client = httpClient.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(GitHubService::class.java)
    }

    override fun getUser(): Single<UserRemoteModel> = service.getUser()

}