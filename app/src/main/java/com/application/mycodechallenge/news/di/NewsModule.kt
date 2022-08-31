package com.application.mycodechallenge.news.di

import com.application.mycodechallenge.core.api.RestService
import com.application.mycodechallenge.core.util.ResponseHandler
import com.application.mycodechallenge.news.data.remote.NewsRemoteDataSource
import com.application.mycodechallenge.news.data.remote.NewsRemoteDataSourceImpl
import com.application.mycodechallenge.news.data.repo.NewsRepository
import com.application.mycodechallenge.news.data.repo.NewsRepositoryImpl
import com.application.mycodechallenge.news.usecases.NewsUseCase
import com.application.mycodechallenge.news.usecases.NewsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun providesNewsUseCase(mNewsRepository: NewsRepository): NewsUseCase =
        NewsUseCaseImpl(mNewsRepository)

    @Provides
    fun providesNewsRepository(mNewsRemoteDataSource: NewsRemoteDataSource): NewsRepository =
        NewsRepositoryImpl(mNewsRemoteDataSource)


    @Provides
    fun providesNewsRemoteDataSource(
        restService: RestService,
        responseHandler: ResponseHandler
    ): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(restService, responseHandler)

}