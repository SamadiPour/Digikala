package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Brand
import ir.samadipour.digikala.service.models.sub_models.ProductColor


data class TopSalesNewestModel(
    @SerializedName("responses")
    val responses: List<Response> = listOf()
)

data class Response(
    @SerializedName("hits")
    val hits: Hits = Hits()
)

data class Hits(
    @SerializedName("hits")
    val hits: List<Hit> = listOf()
)

data class Hit(
    @SerializedName("_id")
    val id: Int = 0, // 2225591
    @SerializedName("_source")
    val source: Source = Source()
)

data class Source(
    @SerializedName("Brand")
    val brand: Brand = Brand(),
    @SerializedName("CpcData")
    val cpcData: List<Any> = listOf(),
    @SerializedName("EnTitle")
    val enTitle: String = "",
    @SerializedName("ExistStatus")
    val existStatus: Int = 0, // 2
    @SerializedName("FaTitle")
    val faTitle: String = "", // کاور ایبیزا مدل D-114 مناسب برای گوشی موبایل شیائومی Mi 9T pro
    @SerializedName("Id")
    val id: Int = 0, // 2225591
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-products/114436807.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_90
    @SerializedName("IsFake")
    val isFake: Boolean = false, // true
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("IsSpecialOffer")
    val isSpecialOffer: Boolean = false, // false
    @SerializedName("IsSponsoredOffer")
    val isSponsoredOffer: Boolean = false, // false
    @SerializedName("LikeCounter")
    val likeCounter: Int = 0, // 0
    @SerializedName("MinPrice")
    val minPrice: Int = 0, // 550000
    @SerializedName("MinPriceList")
    val minPriceList: Int = 0, // 0
    @SerializedName("ProductColorList")
    val productColorList: List<ProductColor> = listOf(),
    @SerializedName("Rate")
    val rate: Int = 0, // 0
    @SerializedName("ShowType")
    val showType: Int = 0, // 2
    @SerializedName("UserRating")
    val userRating: Int = 0 // 80
)