package ir.samadipour.digikala.service.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.CategoryRepository
import ir.samadipour.digikala.service.repository.ProductRepository
import ir.samadipour.digikala.service.repository.SearchRepository

class IndexViewModelFactory(
    private val advertisementBannerRepository: AdvertisementBannerRepository,
    private val productRepository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            AdvertisementBannerRepository::class.java,
            ProductRepository::class.java
        ).newInstance(advertisementBannerRepository, productRepository)
    }
}

class CategoryViewModelFactory(
    private val categoryRepository: CategoryRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            CategoryRepository::class.java
        ).newInstance(categoryRepository)
    }
}

class ProductListViewModelFactory(
    private val searchRepository: SearchRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            SearchRepository::class.java
        ).newInstance(searchRepository)
    }
}