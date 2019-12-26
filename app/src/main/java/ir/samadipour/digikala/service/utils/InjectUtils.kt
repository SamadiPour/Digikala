package ir.samadipour.digikala.service.utils

import android.app.Application
import ir.samadipour.digikala.inteface.api_dao.AdvertisementBannerDao
import ir.samadipour.digikala.inteface.api_dao.CategoryDao
import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.CategoryRepository
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import retrofit2.Retrofit

object InjectUtils {

    private val retrofit: Retrofit = RetrofitConfig.retrofit()

    fun getIndexActivityViewModelInstance(application: Application): IndexViewModelFactory {
        val dao = retrofit.create(AdvertisementBannerDao::class.java)
        val repository = AdvertisementBannerRepository(dao)
        return IndexViewModelFactory(repository, application)
    }

    fun getCategoryViewModelInstance(application: Application): CategoryViewModelFactory {
        val dao = retrofit.create(CategoryDao::class.java)
        val repository = CategoryRepository(dao)
        return CategoryViewModelFactory(repository, application)
    }
}