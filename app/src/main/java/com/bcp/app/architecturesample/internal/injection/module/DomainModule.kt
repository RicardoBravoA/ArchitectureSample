package com.bcp.app.architecturesample.internal.injection.module

import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.gateway.UserGateway
import com.bcp.app.domain.interactor.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DomainModule {

    @Provides
    @Singleton
    internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, userGateway: UserGateway): UserUseCase {
        return UserUseCase(schedulers, userGateway)
    }

}