package ir.samadipour.digikala.service.models

import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Banner


data class MainBannerModel(
    @SerializedName("Data")
    val `data`: List<Banner> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)