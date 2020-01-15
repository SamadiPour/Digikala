package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.ImagePaths


data class ProductAlbumModel(
    @SerializedName("Data")
    val `data`: List<Data> = listOf(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class Data(
    @SerializedName("ImagePaths")
    val imagePaths: ImagePaths = ImagePaths(),
    @SerializedName("ProductPhotoId")
    val productPhotoId: Int = 0, // 17
    @SerializedName("Row")
    val row: Int = 0, // 18
    @SerializedName("sort")
    val sort: Int = 0, // 17
    @SerializedName("type")
    val type: String = "" // 17
)