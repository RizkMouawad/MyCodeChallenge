package com.application.mycodechallenge.news.data.remote

import com.application.mycodechallenge.core.api.RestService
import com.application.mycodechallenge.core.util.ResponseHandler
import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.model.Response

class NewsRemoteDataSourceImpl constructor(
    private val restService: RestService,
    private val responseHandler: ResponseHandler
) : NewsRemoteDataSource {
    override suspend fun getNews(): Resource<Response> {
        return try {
            responseHandler.handleSuccess(restService.getNews())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }


}