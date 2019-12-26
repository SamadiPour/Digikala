package ir.samadipour.digikala.service.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.CategoryRepository

class IndexViewModelFactory(
    private val advertisementBannerRepository: AdvertisementBannerRepository,
    private val application: Application
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            AdvertisementBannerRepository::class.java,
            Application::class.java
        ).newInstance(advertisementBannerRepository, application)
    }
}

class CategoryViewModelFactory(
    private val categoryRepository: CategoryRepository,
    private val application: Application
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(ViewModel: Class<T>): T {
        return ViewModel.getConstructor(
            CategoryRepository::class.java,
            Application::class.java
        ).newInstance(categoryRepository, application)
    }
}