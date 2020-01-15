package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Color


data class ProductConfigModel(
    @SerializedName("Data")
    val `data`: ProductConfigData = ProductConfigData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductConfigData(
    @SerializedName("Colors")
    val colors: List<Color> = listOf(),
    @SerializedName("ConfigNum")
    val configNum: Int = 0, // 3
    @SerializedName("ConfigViewModel")
    val configViewModel: ConfigViewModel = ConfigViewModel(),
    @SerializedName("Sizes")
    val sizes: Any = Any() // null
)

data class ConfigViewModel(
    @SerializedName("Color")
    val color: Color = Color(),
    @SerializedName("DefaultBuyBox")
    val defaultBuyBox: Boolean = false, // true
    @SerializedName("DigibonReceived")
    val digibonReceived: Int = 0, // 0
    @SerializedName("DigibonUsable")
    val digibonUsable: Int = 0, // 0
    @SerializedName("Discount")
    val discount: Int = 0, // 0
    @SerializedName("Gifts")
    val gifts: Any = Any(), // null
    @SerializedName("Id")
    val id: Int = 0, // 5528955
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("MaxCount")
    val maxCount: Int = 0, // 1
    @SerializedName("Payable")
    val payable: Int = 0, // 17350000
    @SerializedName("Price")
    val price: Int = 0, // 17350000
    @SerializedName("PriceId")
    val priceId: Int = 0, // 162835406
    @SerializedName("Seller")
    val seller: Seller = Seller(),
    @SerializedName("SellerRatesCount")
    val sellerRatesCount: Int = 0, // 3627
    @SerializedName("SellerRating")
    val sellerRating: Int = 0, // 85
    @SerializedName("Size")
    val size: Any = Any(), // null
    @SerializedName("Warranty")
    val warranty: Warranty = Warranty()
)

data class Seller(
    @SerializedName("ConfigId")
    val configId: Int = 0, // 5528955
    @SerializedName("FullName")
    val fullName: String = "", // آواژنگ
    @SerializedName("Id")
    val id: Int = 0, // 778
    @SerializedName("LeadTime")
    val leadTime: Int = 0, // 0
    @SerializedName("LogoPath")
    val logoPath: String = ""
)

data class Warranty(
    @SerializedName("Id")
    val id: Int = 0, // 765
    @SerializedName("Title")
    val title: String = "" // گارانتی 18 ماهه آواژنگ
)