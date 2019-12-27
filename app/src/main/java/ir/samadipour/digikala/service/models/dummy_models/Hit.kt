package ir.samadipour.digikala.service.models.dummy_models

import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Product

data class Hit(
    @SerializedName("_id")
    val id: Int = 0, // 2225591
    @SerializedName("_source")
    val source: Product = Product()
)