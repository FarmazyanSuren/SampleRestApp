package com.sf.core.datasource

import com.sf.core.WrappedResponse
import com.sf.core.model.Channel
import com.sf.core.model.NewsItem
import kotlinx.coroutines.flow.Flow

interface ChannelDataSource {
    suspend fun getChannel(): WrappedResponse<Channel>
    suspend fun getChannelFromDb(): Flow<List<NewsItem>>
}