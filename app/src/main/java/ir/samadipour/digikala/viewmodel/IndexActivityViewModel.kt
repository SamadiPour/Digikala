package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.*
import ir.samadipour.digikala.inteface.enum.BannerTypeEnum
import ir.samadipour.digikala.service.models.ProductListModel
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.IncredibleProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class IndexActivityViewModel(
    private val bannerRepository: AdvertisementBannerRepository,
    private val productRepository: IncredibleProductRepository
) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job

    fun getSliderBanner() = liveData {
        emit(bannerRepository.getMainBanners(BannerTypeEnum.SLIDER))
    }

    fun getFullScreenBanners() = liveData {
        emit(bannerRepository.getMainBanners(BannerTypeEnum.ADVERTISEMENT))
    }

    fun getMidScreenBanner() = liveData {
        emit(bannerRepository.getMidScreenBanners())
    }

    fun getIncredibleOffers() = liveData {
        emit(productRepository.getIncredibleOffers())
    }

    fun getGeneralProducts() = liveData {
        emit(productRepository.getGeneralProducts())
    }

    fun getTopListOfCategory(vararg category: Int): List<LiveData<ProductListModel>> {
        val data = List<MutableLiveData<ProductListModel>>(category.size) { MutableLiveData() }
        for (index in category.indices) {
            viewModelScope.launch(coroutineContext) {
                val response = productRepository.getTopListOfCategory("c${category[index]}")
                data[index].postValue(response)
            }
        }
        return data
    }

}