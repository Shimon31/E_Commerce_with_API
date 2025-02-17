package com.shimon.e_commercepractice.di

import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.Services.UploadService
import com.shimon.e_commercepractice.Services.UserService
import com.shimon.e_commercepractice.Utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit.Builder): AuthService {
        return retrofit.build().create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUploadService(retrofit: Retrofit.Builder): UploadService {
        return retrofit.build().create(UploadService::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor =authInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit.Builder,client: OkHttpClient): UserService {
        return retrofit.client(client).build().create(UserService::class.java)
    }
}
