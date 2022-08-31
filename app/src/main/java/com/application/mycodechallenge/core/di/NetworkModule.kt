package com.application.mycodechallenge.core.di

import com.application.mycodechallenge.BuildConfig
import com.application.mycodechallenge.core.api.RestService
import com.application.mycodechallenge.utils.ApiVars
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

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRestService(): RestService {
        return getRestService()
    }

    fun getRestService(): RestService {

        val okHttpClientBuilder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        okHttpClientBuilder.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(40, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            okHttpClientBuilder.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(ApiVars.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(RestService::class.java)

    }
}