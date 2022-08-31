package com.application.mycodechallenge.news.usecases

import androidx.lifecycle.MutableLiveData
import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.model.Response


interface NewsUseCase {

    fun getNews(): MutableLiveData<Resource<Response>>

}