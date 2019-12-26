package ir.samadipour.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.inteface.enum.BannerTypeEnum
import ir.samadipour.digikala.service.models.MainBannerModel
import ir.samadipour.digikala.service.models.MidScreenBannerModel
import ir.samadipour.digikala.service.repository.AdvertisementBannerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class IndexActivityViewModel(
    private val bannerRepository: AdvertisementBannerRepository,
    application: Application
) : AndroidViewModel(application) {
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

}