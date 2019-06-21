package com.bcp.app.architecturesample.internal.injection.module

import android.content.Context
import com.bcp.app.data.BuildConfig
import com.bcp.app.data.gateway.InventoryGatewayImpl
import com.bcp.app.data.gateway.SystemGatewayImpl
import com.bcp.app.data.local.EventLocalDataSource
import com.bcp.app.data.local.EventTypeLocalDataSource
import com.bcp.app.data.local.RatingLocalDataSource
import com.bcp.app.data.local.VenueLocalDataSource
import com.bcp.app.data.local.dao.EventDao
import com.bcp.app.data.local.dao.EventTypeDao
import com.bcp.app.data.local.dao.RatingDao
import com.bcp.app.data.local.dao.VenueDao
import com.bcp.app.data.local.inventory.InventoryDatabase
import com.bcp.app.data.local.system.SystemDatabase
import com.bcp.app.data.remote.EventRemoteDataSource
import com.bcp.app.data.remote.EventTypeRemoteDataSource
import com.bcp.app.data.remote.RatingRemoteDataSource
import com.bcp.app.data.remote.VenueRemoteDataSource
import com.bcp.app.data.remote.api.TheatreApi
import com.bcp.app.data.remote.api.TheatreService
import com.bcp.app.data.repository.EventRepository
import com.bcp.app.data.repository.EventTypeRepository
import com.bcp.app.data.repository.RatingRepository
import com.bcp.app.data.repository.VenueRepository
import com.bcp.app.data.repository.mapper.EventMapper
import com.bcp.app.data.repository.mapper.EventTypeMapper
import com.bcp.app.data.repository.mapper.RatingMapper
import com.bcp.app.data.repository.mapper.VenueMapper
import com.bcp.app.domain.gateway.InventoryGateway
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
    internal fun provideVenueRemoteDataSource(theatreService: TheatreService): VenueRemoteDataSource {
        return VenueRemoteDataSource(theatreService)
    }

    @Provides
    @Singleton
    internal fun provideEventRemoteDataSource(theatreService: TheatreService): EventRemoteDataSource {
        return EventRemoteDataSource(theatreService)
    }

    @Provides
    @Singleton
    internal fun provideRatingRemoteDataSource(theatreService: TheatreService): RatingRemoteDataSource {
        return RatingRemoteDataSource(theatreService)
    }

    @Provides
    @Singleton
    internal fun provideSystemDatabase(context: Context): SystemDatabase {
        return SystemDatabase.newInstance(context)
    }

    @Provides
    @Singleton
    internal fun provideInventoryDatabase(context: Context): InventoryDatabase {
        return InventoryDatabase.newInstance(context)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeDao(systemDatabase: SystemDatabase): EventTypeDao = systemDatabase.eventTypeDao()

    @Provides
    @Singleton
    internal fun provideVenueDao(systemDatabase: SystemDatabase): VenueDao = systemDatabase.venueDao()

    @Provides
    @Singleton
    internal fun provideEventDao(inventoryDatabase: InventoryDatabase): EventDao = inventoryDatabase.eventDao()

    @Provides
    @Singleton
    internal fun provideRatingTypeDao(inventoryDatabase: InventoryDatabase): RatingDao = inventoryDatabase.ratingDao()

    @Provides
    @Singleton
    internal fun provideEventTypeDiskDataSource(eventTypeDao: EventTypeDao): EventTypeLocalDataSource {
        return EventTypeLocalDataSource(eventTypeDao)
    }

    @Provides
    @Singleton
    internal fun provideVenueDiskDataSource(venueDao: VenueDao): VenueLocalDataSource {
        return VenueLocalDataSource(venueDao)
    }

    @Provides
    @Singleton
    internal fun provideEventDiskDataSource(eventDao: EventDao): EventLocalDataSource {
        return EventLocalDataSource(eventDao)
    }

    @Provides
    @Singleton
    internal fun provideRatingDiskDataSource(ratingDao: RatingDao): RatingLocalDataSource {
        return RatingLocalDataSource(ratingDao)
    }

    @Provides
    @Singleton
    internal fun provideEventTypeRepository(eventTypeLocalDataSource: EventTypeLocalDataSource,
                                            eventTypeRemoteDataSource: EventTypeRemoteDataSource): EventTypeRepository {
        return EventTypeRepository(eventTypeLocalDataSource, eventTypeRemoteDataSource, EventTypeMapper())
    }

    @Provides
    @Singleton
    internal fun provideVenueRepository(venueLocalDataSource: VenueLocalDataSource,
                                        venueRemoteDataSource: VenueRemoteDataSource): VenueRepository {
        return VenueRepository(venueLocalDataSource, venueRemoteDataSource, VenueMapper())
    }

    @Provides
    @Singleton
    internal fun provideEventRepository(eventLocalDataSource: EventLocalDataSource,
                                        eventRemoteDataSource: EventRemoteDataSource): EventRepository {
        return EventRepository(eventLocalDataSource, eventRemoteDataSource, EventMapper())
    }

    @Provides
    @Singleton
    internal fun provideRatingRepository(ratingLocalDataSource: RatingLocalDataSource,
                                         ratingRemoteDataSource: RatingRemoteDataSource): RatingRepository {
        return RatingRepository(ratingLocalDataSource, ratingRemoteDataSource, RatingMapper())
    }

    @Provides
    @Singleton
    internal fun provideSystemRepository(eventTypeRepository: EventTypeRepository): SystemGateway {
        return SystemGatewayImpl(eventTypeRepository)
    }

    @Provides
    @Singleton
    internal fun provideInventoryRepository(eventTypeRepository: EventTypeRepository,
                                            eventRepository: EventRepository,
                                            venueRepository: VenueRepository,
                                            ratingRepository: RatingRepository): InventoryGateway {
        return InventoryGatewayImpl(eventTypeRepository, eventRepository, venueRepository, ratingRepository)
    }
}