package com.sf.core.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
@Xml(name = "channel")
class Channel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @PropertyElement(name = "title")
    val title: String?,
    @PropertyElement(name = "link")
    val link: String?,
    @PropertyElement(name = "description")
    val description: String?,
    @Element(name = "image")
    val image: NewsImage?,
    @PropertyElement(name = "managingEditor")
    val managingEditor: String?,
    @PropertyElement(name = "webMaster")
    val webMaster: String?,
    @Element(name = "item")
    val entryList: List<NewsItem>?
) : Parcelable