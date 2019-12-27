package ir.samadipour.digikala.service.models.dummy_models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("hits")
    val hits: Hits = Hits()
)
