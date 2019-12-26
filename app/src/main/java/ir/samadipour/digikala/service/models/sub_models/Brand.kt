package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("Id")
    val id: Int = 0, // 719
    @SerializedName("Title")
    val title: String = "" // Miscellaneous
)