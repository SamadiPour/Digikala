package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.AdvertisementBannerDao
import ir.samadipour.digikala.inteface.enum.BannerTypeEnum
import ir.samadipour.digikala.service.models.MainBannerModel
import ir.samadipour.digikala.service.models.MidScreenBannerModel


class AdvertisementBannerRepository(private val bannerDao: AdvertisementBannerDao) {

    suspend fun getMainBanners(bannerType: BannerTypeEnum): MainBannerModel? {
        try {
            val result = bannerDao.getMainBanners(bannerType.value)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getMidScreenBanners(): MidScreenBannerModel? {
        try {
            val result = bannerDao.getMidScreenBanners()
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}