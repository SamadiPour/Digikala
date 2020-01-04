package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.SearchDao
import ir.samadipour.digikala.service.models.dummy_models.Response

class SearchRepository(private val searchDao: SearchDao) {
    var page: Int = 0

    suspend fun getProductSortBased(
        apiFilterNumber: Int,
        reset: Boolean = false
    ): Response? {
        if (reset) page = 0
        try {
            val result = searchDao.getProductSortBased(
                sortBy = apiFilterNumber,
                pageSize = 10,
                pageno = page
            )
            return if (result.isSuccessful && result.body() != null) {
                page++
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}