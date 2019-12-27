package ir.samadipour.digikala.service.models.dummy_models

import com.google.gson.annotations.SerializedName

data class Hits(
    @SerializedName("hits")
    val hits: List<Hit> = listOf()
)