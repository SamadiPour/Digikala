package ir.samadipour.digikala.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.inteface.enum.ProductListSortTypeEnum
import ir.samadipour.digikala.service.click_listener.BannerClickListener
import ir.samadipour.digikala.service.models.*
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.view.adapter.CategoryChipsAdapter
import ir.samadipour.digikala.view.adapter.ImageSliderAdapter
import ir.samadipour.digikala.view.adapter.ProductListAdapter
import ir.samadipour.digikala.view.adapter.SpecialOfferAdapter
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import ir.samadipour.digikala.viewmodel.IndexActivityViewModel
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.item_list_simple_image.view.*
import kotlinx.android.synthetic.main.list_item_card_image_small.view.*
import kotlinx.android.synthetic.main.row_product_list.view.*
import kotlinx.android.synthetic.main.toolbar_actionbar.*
import kotlinx.android.synthetic.main.toolbar_actionbar.view.*
import kotlin.math.floor


class IndexActivity : AppCompatActivity(), Observer<Any?>,
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var inflater: LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        inflater = LayoutInflater.from(this)
        DisplayTools.switchVisibility(rootView_indexActivity, splashScreen_indexActivity, false)
        Handler().postDelayed({
            DisplayTools.switchVisibility(rootView_indexActivity, splashScreen_indexActivity, false)
        }, 3000)

        val indexViewModel = ViewModelProvider(
            this,
            InjectUtils.getIndexActivityViewModelInstance()
        ).get(IndexActivityViewModel::class.java)

        //requesting category
        ViewModelProvider(
            this,
            InjectUtils.getCategoryViewModelInstance()
        ).get(CategoryViewModel::class.java)

        DisplayTools.toolbar(
            this,
            showDigikala = true,
            showHamburger = true,
            showSearch = true,
            showBasket = true
        )

        DisplayTools.handleCountDownTimer(
            hourCounter_indexTextView,
            minuteCounter_indexTextView,
            secondCounter_indexTextView
        )

        toolbar.menuButton.setOnClickListener {
            indexActivity_drawerLayout.openDrawer(indexActivity_navigationView)
        }
        indexActivity_navigationView.setNavigationItemSelectedListener(this)

        //banner slider
        indexViewModel.getSliderBanner().observe(this, Observer { bannerModel ->
            if (bannerModel != null) {
                val imageSliderAdapter = ImageSliderAdapter(fullScreen = true)
                imageSlider_banners.sliderAdapter = imageSliderAdapter
                imageSliderAdapter.submit(bannerModel.data.map { it.bannerPathMobile })
            }
        })


        //category chips
        CategoryViewModel.data.observe(this, this)
        //FullScreenBanner
        indexViewModel.getFullScreenBanners().observe(this, this)
        //mid screen banner request
        indexViewModel.getMidScreenBanner().observe(this, this)
        //incredible offers request
        indexViewModel.getIncredibleOffers().observe(this, this)
        //TopSales and Newest request
        indexViewModel.getGeneralProducts().observe(this, this)

        //4 categories in below
        val categoryNames = listOf(
            "گوشی موبایل",
            "لپ تاپ و الترابوک",
            "خانه و آشپزخانه",
            "کالای دیجیتال"
        )
        val viewsIdes = listOf(
            mobilePhone_rowList,
            laptops_rowList,
            homeAndKitchen_rowList,
            digitalProduct_rowList
        )
        val topProductOfCats = indexViewModel.getTopListOfCategory(11, 18, 6226, 5966)
        for (index in topProductOfCats.indices) {
            topProductOfCats[index].observe(this, Observer {
                if (it != null) {
                    val adapter = ProductListAdapter(isGone = true, showDiscounted = false)
                    viewsIdes[index].apply {
                        productListRow_productRecyclerView.adapter = adapter
                        productListRow_titleTextView.text = categoryNames[index]
                    }
                    adapter.submit(it.responses[0].hits.hits)
                }
            })
        }
    }

    override fun onChanged(result: Any?) {
        when (result) {
            is CategoriesModel -> {
                //setting category chips
                val categoryAdapter = CategoryChipsAdapter(result.data)
                chipsView_productCategories.adapter = categoryAdapter
            }
            is MainBannerModel -> {
                //setting top full screen banner
                firstFullScreenBanner.setImageURI(result.data[0].bannerPathMobile)
                firstFullScreenBanner.setOnClickListener(
                    BannerClickListener(
                        result.data[0]
                    )
                )

                //setting bottom full screen banner
                secondFullScreenBanner.setImageURI(result.data[1].bannerPathMobile)
                secondFullScreenBanner.setOnClickListener(
                    BannerClickListener(
                        result.data[1]
                    )
                )
            }
            is MidScreenBannerModel -> {
                //creating mid screen banners
                bindBanners(result)
            }
            is IncredibleOfferModel -> {
                //incredible offers
                val specialOfferAdapter = SpecialOfferAdapter(result.data)
                specialOffer_productList.adapter = specialOfferAdapter
            }
            is ProductListModel -> {
                //TopSales
                val topSalesAdapter =
                    ProductListAdapter(isGone = true, showDiscounted = false).apply {
                        submit(result.responses[0].hits.hits)
                    }
                topSale_rowList.apply {
                    //making full list button visible
                    productListRow_productRecyclerView.adapter = topSalesAdapter
                    productListRow_titleTextView.text = getString(R.string.top_sale_title_text_view)
                    productListRow_moreButton.visibility = View.VISIBLE
                    productListRow_moreButton.setOnClickListener {
                        handleNavigation(R.id.menu_topSellProduct)
                    }
                }

                //Newest Products
                val newestProductsAdapter =
                    ProductListAdapter(isGone = true, showDiscounted = false).apply {
                        submit(result.responses[1].hits.hits)
                    }
                newestProducts_rowList.apply {
                    //making full list button visible
                    productListRow_productRecyclerView.adapter = newestProductsAdapter
                    productListRow_titleTextView.text =
                        getString(R.string.newest_product_title_text_view)
                    productListRow_moreButton.visibility = View.VISIBLE
                    productListRow_moreButton.setOnClickListener {
                        handleNavigation(R.id.menu_newestProducts)
                    }
                }
            }
        }
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
                view.itemList_imageView_large.setImageURI(it.data[1][floor(i / 2.0).toInt()].bannerPathMobile)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean = handleNavigation(item.itemId)

    private fun handleNavigation(itemId: Int): Boolean {
        val destination: Class<*>?
        val bundle = Bundle()
        when (itemId) {
            R.id.menuCategory -> {
                destination = CategoryActivity::class.java
            }
            R.id.menu_topSellProduct -> {
                destination = ProductsListActivity::class.java
                bundle.putParcelable("type", ProductListSortTypeEnum.TOP_SALE)
            }
            R.id.menu_mostViewedProduct -> {
                destination = ProductsListActivity::class.java
                bundle.putParcelable("type", ProductListSortTypeEnum.MOST_VIEWED)
            }
            R.id.menu_newestProducts -> {
                destination = ProductsListActivity::class.java
                bundle.putParcelable("type", ProductListSortTypeEnum.NEWEST)
            }
            else -> return false
        }
        val intent = Intent(this, destination)
        intent.putExtras(bundle)
        indexActivity_drawerLayout.closeDrawer(GravityCompat.END)
        startActivity(intent)
        return false
    }
}