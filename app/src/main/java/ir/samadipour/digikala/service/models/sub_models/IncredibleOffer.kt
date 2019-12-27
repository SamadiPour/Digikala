package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class IncredibleOffer(
    @SerializedName("Discount")
    val discount: Int = 0, // 7160000
    @SerializedName("Id")
    val id: Int = 0, // 1549357
    @SerializedName("ImagePaths")
    val imagePaths: ImagePaths = ImagePaths(),
    @SerializedName("IsFresh")
    val isFresh: Boolean = false, // false
    @SerializedName("OnlyForApplication")
    val onlyForApplication: Boolean = false, // false
    @SerializedName("OnlyForMembers")
    val onlyForMembers: Boolean = false, // false
    @SerializedName("Price")
    val price: Int = 0, // 15150000
    @SerializedName("ProductId")
    val productId: Int = 0, // 1549357
    @SerializedName("Title")
    val title: String = "" // دستبند طلا 18عیار مانچو مدل bfg128
)