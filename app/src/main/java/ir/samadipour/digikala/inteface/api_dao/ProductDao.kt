package ir.samadipour.digikala.inteface.api_dao

import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.models.IncredibleOfferModel
import ir.samadipour.digikala.service.models.ProductListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface ProductDao {

    @GET("api/IncredibleOffer/GetIncredibleOffer")
    suspend fun getIncredibleOffers(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers
    ): Response<IncredibleOfferModel>


    @GET("api2/Data/GetAllTopList")
    suspend fun getGeneralProducts(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers,
        @Query("category") category: String? = null
    ): Response<ProductListModel>
}