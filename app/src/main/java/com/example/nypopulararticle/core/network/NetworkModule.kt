package com.example.nypopulararticle.core.network

import android.util.Log
import com.example.nypopulararticle.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor


/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        networkInterceptor: RequestInterceptor
    ): OkHttpClient = OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(3, TimeUnit.SECONDS)
        .writeTimeout(3, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(networkInterceptor)
        .addInterceptor(
            LoggingInterceptor.Builder()
                .setLevel(Level.BASIC)
                .log(Log.VERBOSE)
                .build()
        )
        .build()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {  HttpLoggingInterceptor.Level.BASIC }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)

            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}