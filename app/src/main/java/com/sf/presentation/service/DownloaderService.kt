package com.sf.presentation.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.room.Room
import com.sf.freamwork.api.ChannelApi
import com.sf.freamwork.database.AppDataBase
import com.sf.freamwork.datasourceimpl.ChannelDataSourceImpl
import kotlinx.coroutines.*

class DownloaderService : Service() {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val dataBase by lazy {
        Room.databaseBuilder(this, AppDataBase::class.java, "channel_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        scope.launch {
            val source = ChannelDataSourceImpl(dataBase.channelDao(), ChannelApi.channelApi)
            while (true) {
                source.getChannel()
                delay(60000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}