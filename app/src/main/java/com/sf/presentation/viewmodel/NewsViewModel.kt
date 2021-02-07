package com.sf.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.sf.core.model.NewsItem
import com.sf.freamwork.api.ChannelApi
import com.sf.freamwork.database.AppDataBase
import com.sf.freamwork.datasourceimpl.ChannelDataSourceImpl
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val dataBase by lazy {
        Room.databaseBuilder(application.applicationContext, AppDataBase::class.java, "channel_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    val listLiveData: MutableLiveData<List<NewsItem>> = MutableLiveData()

    private val sourceImpl = ChannelDataSourceImpl(dataBase.channelDao(), ChannelApi.channelApi)

    @InternalCoroutinesApi
    fun updateList() {
        viewModelScope.launch {
            sourceImpl.getChannelFromDb().collect {
                listLiveData.postValue(it)
            }
        }
    }

}