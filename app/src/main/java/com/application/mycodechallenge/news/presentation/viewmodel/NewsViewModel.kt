package com.application.mycodechallenge.news.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.usecases.NewsUseCase
import com.application.mycodechallenge.news.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val mNewsUseCase: NewsUseCase
) : ViewModel(){
    var response: MutableLiveData<Resource<Response>> = MutableLiveData()

    fun getNews() {
        response = mNewsUseCase.getNews()
    }
}