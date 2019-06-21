package com.bcp.app.architecturesample.internal.injection.module.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bcp.app.architecturesample.EventViewModel
import com.bcp.app.architecturesample.internal.injection.scope.MainScope
import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.gateway.EventTypeGateway
import com.bcp.app.domain.interactor.EventTypeGetAllUseCase
import dagger.Module
import dagger.Provides

@Module
internal abstract class MainModule {

    @Module
    companion object {

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, eventTypeGateway: EventTypeGateway): EventTypeGetAllUseCase {
            return EventTypeGetAllUseCase(schedulers, eventTypeGateway)
        }

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(context: Context,
                                             eventTypeGetAllUseCase: EventTypeGetAllUseCase): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {
                        modelClass.isAssignableFrom(EventViewModel::class.java) ->
                            EventViewModel(context, eventTypeGetAllUseCase) as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }
}