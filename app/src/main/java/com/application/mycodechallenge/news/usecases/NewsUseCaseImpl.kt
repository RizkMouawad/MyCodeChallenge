package com.application.mycodechallenge.news.usecases

import androidx.lifecycle.MutableLiveData
import com.application.mycodechallenge.core.vo.Resource
import com.application.mycodechallenge.news.data.repo.NewsRepository
import com.application.mycodechallenge.news.model.Response

class NewsUseCaseImpl constructor(private val mNewsRepository: NewsRepository) : NewsUseCase {

    override fun getNews(): MutableLiveData<Resource<Response>> =
        mNewsRepository.getNews()

}
