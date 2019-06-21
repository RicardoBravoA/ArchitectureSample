package com.bcp.app.data.remote.api

import com.bcp.app.data.BuildConfig
import com.bcp.app.data.remote.api.util.AuthenticatorInterceptor
import com.bcp.app.data.remote.api.util.MoshiConverters
import com.bcp.app.data.remote.api.util.RetryAfterInterceptor
import com.bcp.app.data.remote.model.EventRemoteModel
import com.bcp.app.data.remote.model.EventTypeRemoteModel
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class TheatreApi(baseUrl: String) : TheatreService {

    private val service: TheatreService

    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) BODY else BASIC

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthenticatorInterceptor())
            .addInterceptor(RetryAfterInterceptor())

        val client = httpClient.build()

        val moshi = Moshi.Builder()
            .add(Wrapped.ADAPTER_FACTORY)
            .add(MoshiConverters())
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(TheatreService::class.java)
    }

    override fun getEventTypes(): Observable<List<EventTypeRemoteModel>> = service.getEventTypes()

    override fun getEvents(type: Int): Observable<List<EventRemoteModel>> = service.getEvents(type)

    override fun getEvent(id: Int): Observable<EventRemoteModel> = service.getEvent(id)

}