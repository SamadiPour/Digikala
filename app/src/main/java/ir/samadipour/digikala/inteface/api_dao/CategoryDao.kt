package ir.samadipour.digikala.inteface.api_dao

import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.models.MidScreenBannerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface CategoryDao {

    @GET("Category/GetMainMenu")
    suspend fun getMainCategories(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers
    ): Response<CategoriesModel>

}