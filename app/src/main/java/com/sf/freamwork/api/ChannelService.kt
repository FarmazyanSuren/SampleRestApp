package com.sf.freamwork.api

import com.sf.core.model.Channel
import retrofit2.http.GET

interface ChannelService {
    @GET("arm/rss/")
    suspend fun getChannel(): Channel
}