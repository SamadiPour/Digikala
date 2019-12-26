package ir.samadipour.digikala.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository,
    application: Application
) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineContext = Dispatchers.IO + job
    private var fetched = false

    //to have it all the times
    companion object {
        var data = MutableLiveData<CategoriesModel>()
    }

    fun getMainCategories() {
        if (!fetched) {
            viewModelScope.launch(coroutineContext) {
                val response = categoryRepository.getMainCategories()
                data.postValue(response)
            }
            fetched = true
        }
    }

}