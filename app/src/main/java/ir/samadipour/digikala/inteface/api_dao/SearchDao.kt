package ir.samadipour.digikala.inteface.api_dao

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchDao {
    @GET("api2/search/get/")
    suspend fun getProductSortBased(
        @Query("pageSize") pageSize: Int = 10,
        @Query("pageno") pageno: Int = 0,
        @Query("sortBy") sortBy: Int? = null,
        @Query("sortCondition") sortCondition: Int? = null
    ): Response<ir.samadipour.digikala.service.models.dummy_models.Response>
}