package com.application.mycodechallenge.news.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.mycodechallenge.R
import com.application.mycodechallenge.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : BaseActivity() {

    override fun layoutRes(): Int = R.layout.activity_news

}