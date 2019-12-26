package ir.samadipour.digikala.service.repository

import ir.samadipour.digikala.inteface.api_dao.CategoryDao
import ir.samadipour.digikala.service.models.CategoriesModel

class CategoryRepository(private val categoryDao: CategoryDao) {

    suspend fun getMainCategories(): CategoriesModel? {
        try {
            val result = categoryDao.getMainCategories()
            return if (result.isSuccessful && result.body() != null) {
                result.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}