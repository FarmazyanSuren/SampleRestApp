package com.sf.core.model

import android.os.Parcelable
import androidx.room.Entity
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import kotlinx.parcelize.Parcelize

@Xml(name = "item")
@Entity
@Parcelize
data class NewsItem(
    @PropertyElement(name = "title")
    val title: String?,
    @PropertyElement(name = "link")
    val link: String?,
    @PropertyElement(name = "description")
    val description: String?,
    @PropertyElement(name = "pubDate")
    val publishDate: String?
) : Parcelable