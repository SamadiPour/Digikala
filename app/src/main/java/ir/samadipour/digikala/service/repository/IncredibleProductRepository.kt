package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.IncredibleProductDao
import ir.samadipour.digikala.service.models.IncredibleOfferModel
import ir.samadipour.digikala.service.models.ProductListModel

class IncredibleProductRepository(private val incredibleProductDao: IncredibleProductDao) {

    suspend fun getIncredibleOffers(): IncredibleOfferModel? {
        try {
            val result = incredibleProductDao.getIncredibleOffers()
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getGeneralProducts(): ProductListModel? {
        try {
            val result = incredibleProductDao.getGeneralProducts()
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    suspend fun getTopListOfCategory(category: String): ProductListModel? {
        try {
            val result = incredibleProductDao.getGeneralProducts(category = category)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}