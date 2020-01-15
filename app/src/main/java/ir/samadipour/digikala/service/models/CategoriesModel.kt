package ir.samadipour.digikala.service.models

import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Category
import ir.samadipour.digikala.service.models.sub_models.SubCategory


data class CategoriesModel(
    @SerializedName("Data")
    val `data`: List<CategoriesData> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class CategoriesData(
    @SerializedName("Category")
    val category: Category = Category(),
    @SerializedName("SubCategory")
    val subCategory: List<SubCategory> = listOf()
)
