package com.bcp.app.architecturesample.internal.injection.module

import android.content.Context
import com.bcp.app.data.BuildConfig
import com.bcp.app.data.gateway.UserGatewayImpl
import com.bcp.app.data.local.UserLocalDataSource
import com.bcp.app.data.local.dao.UserDao
import com.bcp.app.data.local.user.UserDatabase
import com.bcp.app.data.remote.UserRemoteDataSource
import com.bcp.app.data.remote.api.GitHubApi
import com.bcp.app.data.remote.api.GitHubService
import com.bcp.app.data.repository.UserRepository
import com.bcp.app.data.repository.mapper.UserMapper
import com.bcp.app.domain.gateway.UserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DataModule {
    @Provides
    @Singleton
    internal fun provideTheatreService(): GitHubService = GitHubApi(BuildConfig.API_URL)


    @Provides
    @Singleton
    internal fun provideUserRemoteDataSource(gitHubService: GitHubService): UserRemoteDataSource {
        return UserRemoteDataSource(gitHubService)
    }

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): UserDatabase {
        return UserDatabase.newInstance(context)
    }

    @Provides
    @Singleton
    internal fun provideUserDao(userDatabase: UserDatabase): UserDao = userDatabase.eventTypeDao()

    @Provides
    @Singleton
    internal fun provideUserDiskDataSource(userDao: UserDao): UserLocalDataSource {
        return UserLocalDataSource(userDao)
    }

    @Provides
    @Singleton
    internal fun provideUserLocalToRemoteRepository(userLocalDataSource: UserLocalDataSource,
                                                         userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepository(userLocalDataSource, userRemoteDataSource, UserMapper())
    }

    @Provides
    @Singleton
    internal fun provideUserRepository(userRepository: UserRepository): UserGateway {
        return UserGatewayImpl(userRepository)
    }

}