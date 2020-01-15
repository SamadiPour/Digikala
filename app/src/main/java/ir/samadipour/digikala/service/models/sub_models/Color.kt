package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class Color(
    @SerializedName("Code")
    val code: String = "", // #212121
    @SerializedName("HexCode")
    val hexCode: String = "", // #212121
    @SerializedName("Id")
    val id: Int = 0, // 1
    @SerializedName("Title")
    val title: String = "" // مشکی
)