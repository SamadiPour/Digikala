package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.inteface.enum.ProductListSortTypeEnum
import ir.samadipour.digikala.service.models.dummy_models.Response
import ir.samadipour.digikala.service.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProductListActivityViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job
    val data = MutableLiveData<Response>()

    fun getProductSortBased(sort: ProductListSortTypeEnum) {
        viewModelScope.launch(coroutineContext) {
            val response = searchRepository.getProductSortBased(sort.getApiFilterNumber())
            data.postValue(response)
        }
    }
}