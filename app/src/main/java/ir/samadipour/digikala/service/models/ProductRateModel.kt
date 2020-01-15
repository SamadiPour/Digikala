package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName


data class ProductRateModel(
    @SerializedName("Data")
    val `data`: ProductRateData = ProductRateData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductRateData(
    @SerializedName("CategoryRateInfos")
    val categoryRateInfos: List<CategoryRateInfo> = listOf(),
    @SerializedName("rateCounter")
    val rateCounter: Int = 0 // 1602
)

data class CategoryRateInfo(
    @SerializedName("CategoryId")
    val categoryId: Int = 0, // 11
    @SerializedName("CategoryTitle")
    val categoryTitle: String = "", // گوشی موبایل
    @SerializedName("RateFactorInfos")
    val rateFactorInfos: List<RateFactorInfo> = listOf()
)

data class RateFactorInfo(
    @SerializedName("Id")
    val id: Int = 0, // 103
    @SerializedName("RateAverage")
    val rateAverage: Double = 0.0, // 74.5
    @SerializedName("Title")
    val title: String = "" // طراحی و ظاهر
)