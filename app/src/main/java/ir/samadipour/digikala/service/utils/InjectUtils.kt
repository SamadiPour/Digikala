package ir.samadipour.digikala.service.utils

import ir.samadipour.digikala.inteface.api_dao.*
import ir.samadipour.digikala.service.config.RetrofitConfig
import ir.samadipour.digikala.service.repository.*
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

    fun getProductDetailViewModelInstance(): ProductDetailViewModelFactory {
        val dao = retrofit.create(ProductDao::class.java)
        val repository = ProductRepository(dao)
        return ProductDetailViewModelFactory(repository)
    }
}