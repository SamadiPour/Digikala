package ir.samadipour.digikala.service.models

import com.google.gson.annotations.SerializedName


data class PriceChartModel(
    @SerializedName("Data")
    val `data`: PriceChartData = PriceChartData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class PriceChartData(
    @SerializedName("Categories")
    val categories: List<String> = listOf(),
    @SerializedName("Series")
    val series: List<Sery> = listOf()
)

data class Sery(
    @SerializedName("additionalData")
    val additionalData: List<List<String>> = listOf(),
    @SerializedName("data")
    val `data`: List<List<Int>> = listOf(),
    @SerializedName("name")
    val name: String = "", // کسری کامپیوتر | مشکی | گارانتی ایرانیان رهجو گستر
    @SerializedName("step")
    val step: Boolean = false // false
)