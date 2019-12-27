package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.ProductDao
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.models.IncredibleOfferModel
import ir.samadipour.digikala.service.models.ProductListModel

class ProductRepository(private val productDao: ProductDao) {

    suspend fun getIncredibleOffers(): IncredibleOfferModel? {
        try {
            val result = productDao.getIncredibleOffers()
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
            val result = productDao.getGeneralProducts()
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}