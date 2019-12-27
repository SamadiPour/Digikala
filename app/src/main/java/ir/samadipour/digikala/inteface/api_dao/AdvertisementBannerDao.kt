package ir.samadipour.digikala.inteface.api_dao

import com.facebook.common.internal.ImmutableMap
import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.models.MainBannerModel
import ir.samadipour.digikala.service.models.MidScreenBannerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface AdvertisementBannerDao {

    @GET("api/Banner/GetBanner")
    suspend fun getMainBanners(
        @Query("bannerType") type: String, //Advertisement, Slider
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers
    ): Response<MainBannerModel>

    @GET("api/Banner/GetMobileBanner")
    suspend fun getMidScreenBanners(
        @HeaderMap headerMaps: Map<String, String> = RetrofitConfig.headers
    ): Response<MidScreenBannerModel>
}