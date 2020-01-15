package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("Brand")
    val brand: Brand = Brand(),
    @SerializedName("CpcData")
    val cpcData: List<Any> = listOf(),
    @SerializedName("EnTitle")
    val enTitle: String = "", // Samsung Galaxy A10s SM-A107F/DS Dual SIM 32GB Mobile Phone
    @SerializedName("ExistStatus")
    val existStatus: Int = 0, // 2
    @SerializedName("FaTitle")
    val faTitle: String = "", // گوشی موبایل سامسونگ مدل Galaxy A10s SM-A107F/DS دو سیم کارت ظرفیت 32 گیگابایت
    @SerializedName("Id")
    val id: Int = 0, // 2066213
    @SerializedName("ImagePath")
    val imagePath: String = "", // https://dkstatics-public.digikala.com/digikala-products/113562469.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_90
    @SerializedName("IsFake")
    val isFake: Boolean = false, // false
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("IsSpecialOffer")
    val isSpecialOffer: Boolean = false, // false
    @SerializedName("IsSponsoredOffer")
    val isSponsoredOffer: Boolean = false, // false
    @SerializedName("LikeCounter")
    val likeCounter: Int = 0, // 0
    @SerializedName("MinPrice")
    val minPrice: Int = 0, // 18690000
    @SerializedName("MinPriceList")
    val minPriceList: Int = 0, // 0
    @SerializedName("ProductColorList")
    val productColorList: List<ProductColor> = listOf(),
    @SerializedName("Rate")
    val rate: Int = 0, // 0
    @SerializedName("ShowType")
    val showType: Int = 0, // 2
    @SerializedName("UserRating")
    val userRating: Int = 0 // 86
)