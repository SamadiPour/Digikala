package ir.samadipour.digikala.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job
    private var trying = false
    private var fetched = false

    //to have it all the times
    companion object {
        var data = MutableLiveData<CategoriesModel>()
    }

    init {
        if (!fetched && !trying) getMainCategories()
    }

    private fun getMainCategories() {
        if (!fetched) {
            trying = true
            viewModelScope.launch(coroutineContext) {
                val response = categoryRepository.getMainCategories()
                fetched = response != null
                data.postValue(response)
            }
            trying = false
        }
    }
}