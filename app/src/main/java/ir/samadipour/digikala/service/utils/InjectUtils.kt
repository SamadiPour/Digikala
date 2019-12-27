package ir.samadipour.digikala.service.utils

import ir.samadipour.digikala.inteface.api_dao.AdvertisementBannerDao
import ir.samadipour.digikala.inteface.api_dao.CategoryDao
import ir.samadipour.digikala.inteface.api_dao.ProductDao
import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.CategoryRepository
import ir.samadipour.digikala.service.repository.ProductRepository
import retrofit2.Retrofit

object InjectUtils {

    private val retrofit: Retrofit = RetrofitConfig.serviceRetrofit()

    fun getIndexActivityViewModelInstance(): IndexViewModelFactory {
        val advertisementBannerDao = retrofit.create(AdvertisementBannerDao::class.java)
        val advertisementBannerRepository = AdvertisementBannerRepository(advertisementBannerDao)

        val productDao = retrofit.create(ProductDao::class.java)
        val productRepository = ProductRepository(productDao)

        return IndexViewModelFactory(advertisementBannerRepository, productRepository)
    }

    fun getCategoryViewModelInstance(): CategoryViewModelFactory {
        val dao = retrofit.create(CategoryDao::class.java)
        val repository = CategoryRepository(dao)
        return CategoryViewModelFactory(repository)
    }
}