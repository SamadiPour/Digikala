package ir.samadipour.digikala.service.models

import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.dummy_models.Response


data class ProductListModel(
    @SerializedName("responses")
    val responses: List<Response> = listOf()
)