package ir.samadipour.digikala.inteface.api_dao

import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDao {

    @GET("api/ProductCache/GetProductById/{id}")
    suspend fun getProductById(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers,
        @Path("id") id: Int
    ): Response<ProductModel>

    @GET("api/ProductCache/GetUserRateInfoByProductId/{id}")
    suspend fun getUserRateInfoByProductId(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers,
        @Path("id") id: Int
    ): Response<ProductRateModel>

    @GET("api/ProductCache/GetAlbumByProductId/{id}")
    suspend fun getAlbumByProductId(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers,
        @Path("id") id: Int
    ): Response<ProductAlbumModel>

    @GET("api/ProductCache/GetProductDefaultConfigById")
    suspend fun getProductDefaultConfigById(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers,
        @Query("id") id: Int
    ): Response<ProductConfigModel>
}