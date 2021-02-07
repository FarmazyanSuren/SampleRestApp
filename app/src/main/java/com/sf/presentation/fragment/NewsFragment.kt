package com.sf.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sf.presentation.adapter.NewsAdapter
import com.sf.presentation.viewmodel.NewsViewModel
import com.sf.samplerestapp.R

class NewsFragment : Fragment(R.layout.fragment_news) {

    private val newsAdapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<RecyclerView>(R.id.newsRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
        ViewModelProvider(this).get(NewsViewModel::class.java).run {
            listLiveData.observe(viewLifecycleOwner, {
                newsAdapter.submitList(it)
            })
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}