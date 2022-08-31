package com.application.mycodechallenge.news.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.mycodechallenge.R
import com.application.mycodechallenge.core.vo.Status
import com.application.mycodechallenge.news.model.Response
import com.application.mycodechallenge.news.presentation.ui.adapters.NewsAdapter
import com.application.mycodechallenge.news.presentation.viewmodel.NewsViewModel
import com.application.mycodechallenge.utils.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news.view.*

@AndroidEntryPoint
class NewsFragment : Fragment() {


    private val viewModel : NewsViewModel by viewModels()

    lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_news, container, false)

        implementViews()

        return root
    }

    private fun implementViews() {
        getNews()

        root.srlNews.setOnRefreshListener {
            getNews()
        }
    }

    private fun getNews() {
        viewModel.getNews()
        viewModel.response.removeObservers(viewLifecycleOwner)
        viewModel.response.observe(viewLifecycleOwner,
            androidx.lifecycle.Observer { repos ->
                repos?.let {
                    when (repos.status) {
                        Status.LOADING -> {
                            showLoading()
                        }
                        Status.ERROR -> {
                            hideLoading()
                            if (!NetworkUtils.isNetworkAvailable(requireActivity())) {
                                Toast.makeText(
                                    requireActivity(),
                                    getString(R.string.msg_no_internet_connection),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                        Status.SUCCESS -> {
                            hideLoading()
                            addViews(repos.data)
                        }
                    }
                }
            })
    }

    private fun addViews(data: Response?) {
        root.rvNews?.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        root.rvNews?.adapter = NewsAdapter(data?.data)
    }

    private fun showLoading() {
        root.srlNews.isRefreshing = true
    }

    private fun hideLoading() {
        root.srlNews.isRefreshing = false
    }


}
