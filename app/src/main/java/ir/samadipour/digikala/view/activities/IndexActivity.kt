package ir.samadipour.digikala.view.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.MidScreenBannerModel
import ir.samadipour.digikala.service.utils.BannerClickListener
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.view.adapter.CategoryChipsAdapter
import ir.samadipour.digikala.view.adapter.ImageSliderAdapter
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import ir.samadipour.digikala.viewmodel.IndexActivityViewModel
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.list_item_card_image_large.view.*
import kotlinx.android.synthetic.main.list_item_card_image_small.view.*


class IndexActivity : AppCompatActivity() {
    private lateinit var inflater: LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

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
        imageSlider_banners.sliderAdapter = imageSliderAdapter
        indexViewModel.getSliderBanner().observe(this, Observer {
            if (it != null)
                imageSliderAdapter.submit(it.data)
        })

        //category chips
        val categoryAdapter = CategoryChipsAdapter()
        chipsView_productCategories.adapter = categoryAdapter
        CategoryViewModel.data.observe(this, Observer {
            if (it != null)
                categoryAdapter.submit(it.data)
        })

        //FullScreenBanner
        indexViewModel.getFullScreenBanners().observe(this, Observer {
            if (it != null) {
                firstFullScreenBanner.setImageURI(it.data[0].bannerPathMobile)
                firstFullScreenBanner.setOnClickListener { view ->
                    BannerClickListener.onBanner(it.data[0], view)
                }
                secondFullScreenBanner.setImageURI(it.data[1].bannerPathMobile)
                secondFullScreenBanner.setOnClickListener { view ->
                    BannerClickListener.onBanner(it.data[1], view)
                }
            }
        })

        //mid screen banner
        inflater = LayoutInflater.from(this)
        indexViewModel.getMidScreenBanner().observe(this, Observer {
            bindBanners(it)
        })
    }

    private fun bindBanners(it: MidScreenBannerModel) {
        for (i in 0..3) {
            if (i % 2 == 0) {
                val view =
                    inflater.inflate(
                        R.layout.list_item_card_image_large,
                        bannersLinearLayout,
                        false
                    )
                view.itemList_imageView_large.setImageURI(it.data[1][i].bannerPathMobile)
                bannersLinearLayout.addView(view, i)
            } else {
                val view =
                    inflater.inflate(
                        R.layout.list_item_card_image_small,
                        bannersLinearLayout,
                        false
                    )
                view.itemList_imageView_first.setImageURI(it.data[0][i].bannerPathMobile)
                view.itemList_imageView_second.setImageURI(it.data[0][i + 1].bannerPathMobile)
                bannersLinearLayout.addView(view, i)
            }
        }
    }
}
