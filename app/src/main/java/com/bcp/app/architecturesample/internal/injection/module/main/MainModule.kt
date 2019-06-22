package com.bcp.app.architecturesample.internal.injection.module.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bcp.app.architecturesample.UserViewModel
import com.bcp.app.architecturesample.internal.injection.scope.MainScope
import com.bcp.app.domain.Schedulers
import com.bcp.app.domain.gateway.UserGateway
import com.bcp.app.domain.interactor.UserUseCase
import dagger.Module
import dagger.Provides

@Module
internal abstract class MainModule {

    @Module
    companion object {

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideEventTypeGetAllUseCase(schedulers: Schedulers, userGateway: UserGateway): UserUseCase {
            return UserUseCase(schedulers, userGateway)
        }

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(context: Context,
                                             useCase: UserUseCase): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {
                        modelClass.isAssignableFrom(UserViewModel::class.java) ->
                            UserViewModel(context, useCase) as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }
}