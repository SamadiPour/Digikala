package ir.samadipour.digikala.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.databinding.ActivityIndexBinding
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.view.adapter.CategoryChipsAdapter
import ir.samadipour.digikala.view.adapter.ImageSliderAdapter
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import ir.samadipour.digikala.viewmodel.IndexActivityViewModel

class IndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val indexViewModel = ViewModelProvider(
            this,
            InjectUtils.getIndexActivityViewModelInstance(application)
        ).get(IndexActivityViewModel::class.java)

        val categoryViewModel = ViewModelProvider(
            this,
            InjectUtils.getCategoryViewModelInstance(application)
        ).get(CategoryViewModel::class.java)
        categoryViewModel.getMainCategories()

        DisplayTools.toolbar(
            this,
            showDigikala = true,
            showMenu = true,
            showSearch = true,
            showBasket = true
        )

        //banner slider
        val imageSliderAdapter = ImageSliderAdapter()
        binding.imageSliderBanners.sliderAdapter = imageSliderAdapter
        indexViewModel.getSliderBanner().observe(this, Observer {
            if (it != null)
                imageSliderAdapter.submit(it.data)
        })

        //category chips
        val categoryAdapter = CategoryChipsAdapter()
        binding.chipsViewProductCategories.adapter = categoryAdapter
        categoryViewModel.data.observe(this, Observer {
            if (it != null)
                categoryAdapter.submit(it.data)
        })

        //FullScreenBanner
        indexViewModel.getFullScreenBanners().observe(this, Observer {
            if (it != null) {
                binding.firstFullScreenBanner.setImageURI(it.data[0].bannerPathMobile)
                binding.secondFullScreenBanner.setImageURI(it.data[1].bannerPathMobile)
            }
        })
    }
}
