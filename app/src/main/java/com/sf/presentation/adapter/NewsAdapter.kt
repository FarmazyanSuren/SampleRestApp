package com.sf.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sf.core.model.NewsItem
import com.sf.samplerestapp.R

class NewsAdapter : ListAdapter<NewsItem, NewsAdapter.NewsHolder>(NewsDifCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val currentItem = getItem(holder.adapterPosition)
        holder.itemView.apply {
            findViewById<TextView>(R.id.newsTitle).text = currentItem.title
            findViewById<TextView>(R.id.newsDescription).text = currentItem.description
            findViewById<TextView>(R.id.newsPublishDate).text = currentItem.publishDate
        }
    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class NewsDifCallback : DiffUtil.ItemCallback<NewsItem>() {
        override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.description == newItem.description &&
                    oldItem.link == newItem.link &&
                    oldItem.publishDate == newItem.publishDate &&
                    oldItem.title == newItem.title
        }
    }
}