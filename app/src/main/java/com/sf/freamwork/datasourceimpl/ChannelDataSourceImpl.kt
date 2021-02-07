package com.sf.freamwork.datasourceimpl

import com.sf.core.WrappedResponse
import com.sf.core.datasource.ChannelDataSource
import com.sf.core.model.Channel
import com.sf.core.model.NewsItem
import com.sf.freamwork.api.ChannelService
import com.sf.freamwork.database.ChannelDao
import kotlinx.coroutines.flow.Flow

class ChannelDataSourceImpl(
    private val channelDao: ChannelDao,
    private val channelService: ChannelService
) : ChannelDataSource {

    override suspend fun getChannel(): WrappedResponse<Channel> {
        return try {
            val response = channelService.getChannel()
            response.entryList?.takeIf { it.isNotEmpty() }?.let {
                channelDao.insertNewsItems(*it.toTypedArray())
                WrappedResponse(WrappedResponse.Status.SUCCESS, response)
            } ?: WrappedResponse(WrappedResponse.Status.ERROR, null, "empty array")
        } catch (e: Exception) {
            WrappedResponse(WrappedResponse.Status.ERROR, null, e.message)
        }
    }

    override suspend fun getChannelFromDb(): Flow<List<NewsItem>> {
        return channelDao.getNewsItems()
    }
}