package ir.samadipour.digikala.service.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.service.repository.*

class IndexViewModelFactory(
    private val advertisementBannerRepository: AdvertisementBannerRepository,
    private val productRepository: IncredibleProductRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            AdvertisementBannerRepository::class.java,
            IncredibleProductRepository::class.java
        ).newInstance(advertisementBannerRepository, productRepository)
    }
}

class CategoryViewModelFactory(
    private val repository: CategoryRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            CategoryRepository::class.java
        ).newInstance(repository)
    }
}

class ProductListViewModelFactory(
    private val repository: SearchRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            SearchRepository::class.java
        ).newInstance(repository)
    }
}

class ProductDetailViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            ProductRepository::class.java
        ).newInstance(repository)
    }
}