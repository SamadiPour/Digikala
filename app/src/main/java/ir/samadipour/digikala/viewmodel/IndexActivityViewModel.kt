package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.inteface.enum.BannerTypeEnum
import ir.samadipour.digikala.service.models.IncredibleOfferModel
import ir.samadipour.digikala.service.models.MainBannerModel
import ir.samadipour.digikala.service.models.MidScreenBannerModel
import ir.samadipour.digikala.service.models.ProductListModel
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import ir.samadipour.digikala.service.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class IndexActivityViewModel(
    private val bannerRepository: AdvertisementBannerRepository,
    private val productRepository: ProductRepository
) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job

    fun getSliderBanner(): LiveData<MainBannerModel> {
        val data = MutableLiveData<MainBannerModel>()
        viewModelScope.launch(coroutineContext) {
            val response = bannerRepository.getMainBanners(BannerTypeEnum.SLIDER)
            data.postValue(response)
        }
        return data
    }

    fun getFullScreenBanners(): LiveData<MainBannerModel> {
        val data = MutableLiveData<MainBannerModel>()
        viewModelScope.launch(coroutineContext) {
            val response = bannerRepository.getMainBanners(BannerTypeEnum.ADVERTISEMENT)
            data.postValue(response)
        }
        return data
    }

    fun getMidScreenBanner(): LiveData<MidScreenBannerModel> {
        val data = MutableLiveData<MidScreenBannerModel>()
        viewModelScope.launch(coroutineContext) {
            val response = bannerRepository.getMidScreenBanners()
            data.postValue(response)
        }
        return data
    }

    fun getIncredibleOffers(): LiveData<IncredibleOfferModel> {
        val data = MutableLiveData<IncredibleOfferModel>()
        viewModelScope.launch(coroutineContext) {
            val response = productRepository.getIncredibleOffers()
            data.postValue(response)
        }
        return data
    }

    fun getGeneralProducts(): LiveData<ProductListModel> {
        val data = MutableLiveData<ProductListModel>()
        viewModelScope.launch(coroutineContext) {
            val response = productRepository.getGeneralProducts()
            data.postValue(response)
        }
        return data
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