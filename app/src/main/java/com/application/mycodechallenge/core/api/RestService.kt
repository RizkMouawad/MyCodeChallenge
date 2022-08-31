package com.application.mycodechallenge.core.api

import com.application.mycodechallenge.news.model.Response
import retrofit2.http.GET

interface RestService {

    @GET("viewed/7.json?api-key=Rk6GfVjL9XA3A5ipo7bjr2fNh80CpeA5")
    suspend fun getNews(): Response

}