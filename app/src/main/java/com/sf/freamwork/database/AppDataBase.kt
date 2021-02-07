package com.sf.freamwork.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sf.core.model.NewsItem

@Database(entities = [NewsItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun channelDao(): ChannelDao
}