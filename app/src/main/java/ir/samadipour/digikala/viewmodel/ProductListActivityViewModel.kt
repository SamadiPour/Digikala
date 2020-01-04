package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.inteface.enum.ProductListSortTypeEnum
import ir.samadipour.digikala.service.models.dummy_models.Hit
import ir.samadipour.digikala.service.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProductListActivityViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job
    val data = MutableLiveData<List<Hit>>()

    fun getInfiniteProductSortBasedInitial(sort: ProductListSortTypeEnum) {
        viewModelScope.launch(coroutineContext) {
            val response = searchRepository.getProductSortBased(
                sort.getApiFilterNumber(),
                reset = true
            )
            data.postValue(response?.hits?.hits)
        }
    }

    fun getInfiniteProductSortBased(sort: ProductListSortTypeEnum) {
        viewModelScope.launch(coroutineContext) {
            val response = searchRepository.getProductSortBased(sort.getApiFilterNumber())
            if (response?.hits?.hits != null)
                data.postValue(data.value!! + response.hits.hits)
        }
    }
}