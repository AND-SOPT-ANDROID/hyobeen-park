package org.sopt.and.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.repositoryimpl.AuthRepositoryImpl
import org.sopt.and.data.repositoryimpl.MyRepositoryImpl
import org.sopt.and.domain.repository.AuthRepository
import org.sopt.and.domain.repository.MyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindMyRepository(myRepositoryImpl: MyRepositoryImpl): MyRepository
}