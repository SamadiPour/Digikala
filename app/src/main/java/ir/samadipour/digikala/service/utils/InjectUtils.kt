package ir.samadipour.digikala.service.utils

import ir.samadipour.digikala.inteface.api_dao.AdvertisementBannerDao
import ir.samadipour.digikala.inteface.api_dao.CategoryDao
import ir.samadipour.digikala.inteface.api_dao.IncredibleProductDao
import ir.samadipour.digikala.inteface.api_dao.SearchDao
import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.CategoryRepository
import ir.samadipour.digikala.service.repository.IncredibleProductRepository
import ir.samadipour.digikala.service.repository.SearchRepository
import retrofit2.Retrofit

object InjectUtils {

    private val retrofit: Retrofit = RetrofitConfig.serviceRetrofit()

    fun getIndexActivityViewModelInstance(): IndexViewModelFactory {
        val advertisementBannerDao = retrofit.create(AdvertisementBannerDao::class.java)
        val productDao = retrofit.create(IncredibleProductDao::class.java)

        val advertisementBannerRepository = AdvertisementBannerRepository(advertisementBannerDao)
        val productRepository = IncredibleProductRepository(productDao)

        return IndexViewModelFactory(advertisementBannerRepository, productRepository)
    }

    fun getCategoryViewModelInstance(): CategoryViewModelFactory {
        val dao = retrofit.create(CategoryDao::class.java)
        val repository = CategoryRepository(dao)
        return CategoryViewModelFactory(repository)
    }

    fun getProductListViewModelInstance(): ProductListViewModelFactory {
        val dao = retrofit.create(SearchDao::class.java)
        val repository = SearchRepository(dao)
        return ProductListViewModelFactory(repository)
    }
}