package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.ProductDao
import ir.samadipour.digikala.service.models.*

class ProductRepository(private val productDao: ProductDao) {

    suspend fun getProductById(id: Int): ProductModel? {
        try {
            val result = productDao.getProductById(id = id)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getUserRateInfoByProductId(id: Int): ProductRateModel? {
        try {
            val result = productDao.getUserRateInfoByProductId(id = id)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getAlbumByProductId(id: Int): ProductAlbumModel? {
        try {
            val result = productDao.getAlbumByProductId(id = id)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getProductDefaultConfigById(id: Int): ProductConfigModel? {
        try {
            val result = productDao.getProductDefaultConfigById(id = id)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getPriceChart(id: Int): PriceChartModel? {
        try {
            val result = productDao.getPriceChart(id = id)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}