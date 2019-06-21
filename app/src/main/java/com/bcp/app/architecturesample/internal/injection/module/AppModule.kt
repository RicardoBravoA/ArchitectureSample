package com.bcp.app.architecturesample.internal.injection.module

import android.content.Context
import com.bcp.app.architecturesample.internal.injection.DaggerApplication
import com.bcp.app.architecturesample.internal.scheduler.AppSchedulers
import com.bcp.app.architecturesample.navigation.Navigator
import com.bcp.app.domain.Schedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    internal fun providesContext(application: DaggerApplication): Context = application.applicationContext

    @Provides
    @Singleton
    internal fun provideSchedulers(): Schedulers = AppSchedulers()

    @Provides
    @Singleton
    internal fun provideNavigator() = Navigator()

}