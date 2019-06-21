package com.bcp.app.architecturesample.internal.injection.module

import android.content.Context
import com.bcp.app.data.BuildConfig
import com.bcp.app.data.gateway.EventTypeGatewayImpl
import com.bcp.app.data.local.EventTypeLocalDataSource
import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.system.EventTypeDatabase
import com.bcp.app.data.remote.EventTypeRemoteDataSource
import com.bcp.app.data.remote.api.TheatreApi
import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.data.repository.mapper.EventTypeMapper
import com.bcp.app.domain.gateway.EventTypeGateway
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
    internal fun provideEventTypeDatabase(context: Context): EventTypeDatabase {
        return EventTypeDatabase.newInstance(context)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeDao(eventTypeDatabase: EventTypeDatabase): EventTypeDao = eventTypeDatabase.eventTypeDao()

    @Provides
    @Singleton
    internal fun provideEventTypeDiskDataSource(eventTypeDao: EventTypeDao): EventTypeLocalDataSource {
        return EventTypeLocalDataSource(eventTypeDao)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeLocalToRemoteRepository(eventTypeLocalDataSource: EventTypeLocalDataSource,
                                            eventTypeRemoteDataSource: EventTypeRemoteDataSource): EventTypeRepository {
        return EventTypeRepository(eventTypeLocalDataSource, eventTypeRemoteDataSource, EventTypeMapper())
    }

    @Provides
    @Singleton
    internal fun provideEventTypeRepository(eventTypeRepository: EventTypeRepository): EventTypeGateway {
        return EventTypeGatewayImpl(eventTypeRepository)
    }

}