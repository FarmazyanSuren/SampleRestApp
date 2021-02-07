package com.sf.core.model

import android.os.Parcelable
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import kotlinx.parcelize.Parcelize

@Xml(name = "image")
@Parcelize
data class NewsImage(
    @PropertyElement(name = "url")
    val url: String?,
    @PropertyElement(name = "title")
    val title: String?,
    @PropertyElement(name = "link")
    val link: String?
) : Parcelable
