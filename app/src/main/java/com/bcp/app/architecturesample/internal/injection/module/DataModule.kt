package com.bcp.app.architecturesample.internal.injection.module

import android.content.Context
import com.bcp.app.data.BuildConfig
import com.bcp.app.data.gateway.SystemGatewayImpl
import com.bcp.app.data.local.EventTypeLocalDataSource
import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.system.SystemDatabase
import com.bcp.app.data.remote.EventTypeRemoteDataSource
import com.bcp.app.data.remote.api.TheatreApi
import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.data.repository.mapper.EventTypeMapper
import com.bcp.app.domain.gateway.SystemGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DataModule {
    @Provides
    @Singleton
    internal fun provideTheatreService(): TheatreService = TheatreApi(BuildConfig.API_URL)


    @Provides
    @Singleton
    internal fun provideEventTypeRemoteDataSource(theatreService: TheatreService): EventTypeRemoteDataSource {
        return EventTypeRemoteDataSource(theatreService)
    }

    @Provides
    @Singleton
    internal fun provideSystemDatabase(context: Context): SystemDatabase {
        return SystemDatabase.newInstance(context)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeDao(systemDatabase: SystemDatabase): EventTypeDao = systemDatabase.eventTypeDao()

    @Provides
    @Singleton
    internal fun provideEventTypeDiskDataSource(eventTypeDao: EventTypeDao): EventTypeLocalDataSource {
        return EventTypeLocalDataSource(eventTypeDao)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeRepository(eventTypeLocalDataSource: EventTypeLocalDataSource,
                                            eventTypeRemoteDataSource: EventTypeRemoteDataSource): EventTypeRepository {
        return EventTypeRepository(eventTypeLocalDataSource, eventTypeRemoteDataSource, EventTypeMapper())
    }

    @Provides
    @Singleton
    internal fun provideSystemRepository(eventTypeRepository: EventTypeRepository): SystemGateway {
        return SystemGatewayImpl(eventTypeRepository)
    }

}