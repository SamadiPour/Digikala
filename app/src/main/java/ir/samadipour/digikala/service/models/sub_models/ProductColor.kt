package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class ProductColor(
    @SerializedName("ColorCode")
    val colorCode: String = "", // #2196f3
    @SerializedName("ColorHex")
    val colorHex: String = "", // #2196f3
    @SerializedName("ColorId")
    val colorId: Int = 0, // 4
    @SerializedName("ColorTitle")
    val colorTitle: String = "", // آبی
    @SerializedName("IsActive")
    val isActive: Boolean = false, // true
    @SerializedName("ProductId")
    val productId: Int = 0 // 2225591
)