package com.bcp.app.architecturesample.internal.injection.component

import com.bcp.app.architecturesample.internal.injection.DaggerApplication
import com.bcp.app.architecturesample.internal.injection.module.ActivitiesModule
import com.bcp.app.architecturesample.internal.injection.module.AppModule
import com.bcp.app.architecturesample.internal.injection.module.DataModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        DataModule::class]
)
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}