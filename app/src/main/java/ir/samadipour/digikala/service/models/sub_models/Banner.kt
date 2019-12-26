package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("BannerId")
    val bannerId: String = "", // 25817
    @SerializedName("BannerPathMobile")
    val bannerPathMobile: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000015950.jpg
    @SerializedName("BannerPathTablet")
    val bannerPathTablet: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000015950.jpg
    @SerializedName("BannerType")
    val bannerType: String = "", // Slider
    @SerializedName("campaignId")
    val campaignId: String = "", // 2174
    @SerializedName("DisplayWeight")
    val displayWeight: Int = 0, // 20
    @SerializedName("EndDateTime")
    val endDateTime: String = "", // 2018-08-08T22:13:02.180Z
    @SerializedName("Height")
    val height: Int = 0, // 0
    @SerializedName("Id")
    val id: String = "", // 25817
    @SerializedName("LinkType")
    val linkType: String = "", // ProductList
    @SerializedName("LinkValue")
    val linkValue: String = "", // /Search/BannerId-25817/Keyword-cmp_148423/
    @SerializedName("PatternImagePath")
    val patternImagePath: String = "", // https://dkstatics-public.digikala.com/digikala-adservice-banners/1000015950.jpg
    @SerializedName("StartDateTime")
    val startDateTime: String = "", // 2018-08-08T22:13:02.180Z
    @SerializedName("Title")
    val title: String = "", // عینک و ساعت
    @SerializedName("Width")
    val width: Int = 0 // 0
)