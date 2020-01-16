package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ir.samadipour.digikala.service.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class ProductDetailActivityViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job

    fun getAlbumByProductId(id: Int) = liveData {
        emit(repository.getAlbumByProductId(id))
    }

    fun getProductById(id: Int) = liveData {
        emit(repository.getProductById(id))
    }

    fun getProductDefaultConfigById(id: Int) = liveData {
        emit(repository.getProductDefaultConfigById(id))
    }

    fun getUserRateInfoByProductId(id: Int) = liveData {
        emit(repository.getUserRateInfoByProductId(id))
    }

    fun getPriceChart(id: Int) = liveData {
        emit(repository.getPriceChart(id))
    }
}