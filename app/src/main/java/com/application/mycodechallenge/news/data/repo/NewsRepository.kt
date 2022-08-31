package com.application.mycodechallenge.news.data.repo

import androidx.lifecycle.MutableLiveData
import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.model.Response

interface NewsRepository {

    fun getNews(): MutableLiveData<Resource<Response>>

}