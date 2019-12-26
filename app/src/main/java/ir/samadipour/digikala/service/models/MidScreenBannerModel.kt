package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName


data class MidScreenBannerModel(
    @SerializedName("Data")
    val `data`: List<Any> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)