package ir.samadipour.digikala.service.models.sub_models

import com.google.gson.annotations.SerializedName

data class ImagePaths(
    @SerializedName("Original")
    val original: String = "", // https://dkstatics-public-2.digikala.com/digikala-products/110788668.jpg?x-oss-process=image/resize,w_1280/quality,q_80
    @SerializedName("Size110")
    val size110: String = "", // https://dkstatics-public-2.digikala.com/digikala-products/110788668.jpg?x-oss-process=image/resize,w_110/quality,q_60
    @SerializedName("Size180")
    val size180: String = "", // https://dkstatics-public-2.digikala.com/digikala-products/110788668.jpg?x-oss-process=image/resize,w_180/quality,q_60
    @SerializedName("Size220")
    val size220: String = "", // https://dkstatics-public-2.digikala.com/digikala-products/110788668.jpg?x-oss-process=image/resize,w_220/quality,q_60
    @SerializedName("Size70")
    val size70: String = "" // https://dkstatics-public-2.digikala.com/digikala-products/110788668.jpg?x-oss-process=image/resize,w_70/quality,q_60
)