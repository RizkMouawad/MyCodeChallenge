package com.application.mycodechallenge.news.data.remote

import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.model.Response

interface NewsRemoteDataSource {

    suspend fun getNews(): Resource<Response>

}