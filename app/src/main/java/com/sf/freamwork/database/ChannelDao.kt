package com.sf.freamwork.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sf.core.model.NewsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsItems(vararg items: NewsItem)

    @Query("SELECT * FROM NewsItem")
    suspend fun getNewsItems(): Flow<List<NewsItem>>
}