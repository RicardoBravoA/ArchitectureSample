package com.bcp.app.architecturesample.internal.injection.module

import com.bcp.app.architecturesample.MainActivity
import com.bcp.app.architecturesample.internal.injection.module.main.MainModule
import com.bcp.app.architecturesample.internal.injection.scope.MainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}