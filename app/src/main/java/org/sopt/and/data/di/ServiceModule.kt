package org.sopt.and.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.di.qualifier.Wavve
import org.sopt.and.data.service.AuthService
import org.sopt.and.data.service.MyService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideAuthService(@Wavve retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideMyService(@Wavve retrofit: Retrofit): MyService =
        retrofit.create(MyService::class.java)
}