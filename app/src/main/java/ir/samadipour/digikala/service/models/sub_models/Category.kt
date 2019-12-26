package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("HasMainPage")
    val hasMainPage: Boolean = false, // true
    @SerializedName("Id")
    val id: Int = 0, // 10061
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-categories/1000000111.jpg?x-oss-process=image/resize,m_fill,h_144,w_96/quality,q_90
    @SerializedName("QueryStringValue")
    val queryStringValue: String = "", // /dk-ds-gift-card
    @SerializedName("Title")
    val title: String = "", // کارت هدیه
    @SerializedName("UrlCode")
    val urlCode: String = "" // dk-ds-gift-card
)