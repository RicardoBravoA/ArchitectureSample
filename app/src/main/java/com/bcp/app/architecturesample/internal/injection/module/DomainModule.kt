package com.bcp.app.architecturesample.internal.injection.module

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.gateway.InventoryGateway
import com.bcp.app.domain.gateway.SystemGateway
import com.bcp.app.domain.interactor.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DomainModule {

    @Provides
    @Singleton
    internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, systemGateway: SystemGateway): EventTypeGetAllUseCase {
        return EventTypeGetAllUseCase(schedulers, systemGateway)
    }

    @Provides
    @Singleton
    internal fun provideEventFindByTypeUseCase(schedulers: Schedulers, inventoryGateway: InventoryGateway): EventFindByTypeUseCase {
        return EventFindByTypeUseCase(schedulers, inventoryGateway)
    }

    @Provides
    @Singleton
    internal fun provideEventGetByIdUseCase(schedulers: Schedulers, inventoryGateway: InventoryGateway): EventGetByIdUseCase {
        return EventGetByIdUseCase(schedulers, inventoryGateway)
    }

    @Provides
    @Singleton
    internal fun provideVenueGetByIdUseCase(schedulers: Schedulers, inventoryGateway: InventoryGateway): VenueGetByIdUseCase {
        return VenueGetByIdUseCase(schedulers, inventoryGateway)
    }

    @Provides
    @Singleton
    internal fun provideRatingFindByEventUseCase(schedulers: Schedulers, inventoryGateway: InventoryGateway): RatingFindByEventUseCase {
        return RatingFindByEventUseCase(schedulers, inventoryGateway)
    }
}