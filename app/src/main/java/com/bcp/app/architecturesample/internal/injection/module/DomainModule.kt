package com.bcp.app.architecturesample.internal.injection.module

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.gateway.EventTypeGateway
import com.bcp.app.domain.interactor.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DomainModule {

    @Provides
    @Singleton
    internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, eventTypeGateway: EventTypeGateway): EventTypeGetAllUseCase {
        return EventTypeGetAllUseCase(schedulers, eventTypeGateway)
    }

}