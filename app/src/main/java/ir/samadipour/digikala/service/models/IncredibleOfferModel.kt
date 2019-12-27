package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.ImagePaths
import ir.samadipour.digikala.service.models.sub_models.IncredibleOffer


data class IncredibleOfferModel(
    @SerializedName("Data")
    val `data`: List<IncredibleOffer> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)