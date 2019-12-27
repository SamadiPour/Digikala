package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.dummy_models.Response
import ir.samadipour.digikala.service.models.sub_models.Brand
import ir.samadipour.digikala.service.models.sub_models.Product
import ir.samadipour.digikala.service.models.sub_models.ProductColor


data class ProductListModel(
    @SerializedName("responses")
    val responses: List<Response> = listOf()
)