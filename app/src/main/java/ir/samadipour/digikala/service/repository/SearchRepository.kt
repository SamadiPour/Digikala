package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.SearchDao
import ir.samadipour.digikala.service.models.dummy_models.Response

class SearchRepository(private val searchDao: SearchDao) {

    suspend fun getProductSortBased(apiFilterNumber: Int): Response? {
        try {
            val result = searchDao.getProductSortBased(sortBy = apiFilterNumber)
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}