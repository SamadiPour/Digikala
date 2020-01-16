package ir.samadipour.digikala.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.samadipour.digikala.R
import ir.samadipour.digikala.databinding.ActivityProductDetailBinding
import ir.samadipour.digikala.service.models.ProductAlbumModel
import ir.samadipour.digikala.service.models.ProductConfigModel
import ir.samadipour.digikala.service.models.ProductModel
import ir.samadipour.digikala.service.models.ProductRateModel
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.service.utils.strikeThrough
import ir.samadipour.digikala.view.adapter.ImageSliderAdapter
import ir.samadipour.digikala.view.adapter.ProductDetailColorSizeAdapter
import ir.samadipour.digikala.view.adapter.RateAdapter
import ir.samadipour.digikala.viewmodel.ProductDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.toolbar_actionbar.*

class ProductDetailActivity : AppCompatActivity(), Observer<Any?>, Toolbar.OnMenuItemClickListener {
    private lateinit var binding: ActivityProductDetailBinding
    private var productId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)

        DisplayTools.toolbar(
            this,
            showBack = true,
            showBasket = true,
            showMenu = true
        )

        toolbar.setOnMenuItemClickListener(this)

        productId = intent.getIntExtra("id", -1)

        val productViewModel = ViewModelProvider(
            this,
            InjectUtils.getProductDetailViewModelInstance()
        ).get(ProductDetailActivityViewModel::class.java)

        productViewModel.getProductById(productId).observe(this, this)
        productViewModel.getAlbumByProductId(productId).observe(this, this)
        productViewModel.getProductDefaultConfigById(productId).observe(this, this)
        productViewModel.getUserRateInfoByProductId(productId).observe(this, this)
    }

    override fun onChanged(data: Any?) {
        when (data) {
            is ProductModel -> {
                binding.product = data.data

                //changing toolbar
                DisplayTools.toolbar(
                    this,
                    showTitle = true,
                    title = data.data.faTitle,
                    titleSize = 14f,
                    showMenu = true
                )

                //set average rate
                binding.ratingProductDetail.text = getString(
                    R.string.product_rate,
                    data.data.rate.toFloat() * 5 / 100
                )
                binding.ratingBarProductDetail.rating = data.data.rate.toFloat() * 5 / 100

                //special offer timer
                if (data.data.isSpecialOffer) DisplayTools.handleCountDownTimer(
                    hourCounter_productTextView,
                    minuteCounter_productTextView,
                    secondCounter_productTextView
                )

                //more button in description
                binding.continueDescriptionProductDetail.setOnClickListener {
                    if (binding.descriptionProductDetail.maxLines == 8) {
                        binding.descriptionProductDetail.maxLines = Int.MAX_VALUE
                        binding.continueDescriptionProductDetail.text = getString(
                            R.string.continue_description
                        )
                    } else {
                        binding.descriptionProductDetail.maxLines = 8
                        binding.continueDescriptionProductDetail.text = getString(
                            R.string.continue_description
                        )
                    }
                }
            }
            is ProductRateModel -> {
                val rateAdapter = RateAdapter(data.data.categoryRateInfos[0].rateFactorInfos)
                ratingRecyclerView_productDetail.adapter = rateAdapter
            }
            is ProductAlbumModel -> {
                //slider images
                val imageSliderAdapter = ImageSliderAdapter(fullScreen = false)
                imageSlider_productDetail.sliderAdapter = imageSliderAdapter
                imageSliderAdapter.submit(data.data.map { it.imagePaths.original })
            }
            is ProductConfigModel -> {
                binding.productConfig = data.data

                //create Colors/Size list
                when {
                    data.data.sizes != null -> {
                        if (data.data.sizes.isNotEmpty()) {
                            binding.colorSizeRecyclerViewProductDetail.adapter =
                                ProductDetailColorSizeAdapter(data.data.sizes)
                        }
                        colorSizeText_ProductDetail.text = getString(R.string.size)
                        colorSizeCount_ProductDetail.text = getString(
                            R.string.size_count,
                            data.data.sizes.size
                        )
                    }
                    data.data.colors != null -> {
                        if (data.data.colors.isNotEmpty()) {
                            binding.colorSizeRecyclerViewProductDetail.adapter =
                                ProductDetailColorSizeAdapter(data.data.colors)
                        }
                        colorSizeText_ProductDetail.text = getString(R.string.color)
                        colorSizeCount_ProductDetail.text = getString(
                            R.string.color_count,
                            data.data.colors.size
                        )
                    }
                    else -> {
                        colorSizeText_ProductDetail.visibility = View.GONE
                        colorSizeCount_ProductDetail.visibility = View.GONE
                    }
                }

                //setting price
                binding.minPriceProductDetail.text = getString(
                    R.string.price_text,
                    DisplayTools.priceFormatter(data.data.configViewModel.payable)
                )
                if (data.data.configViewModel.discount != 0) {
                    binding.maxPriceProductDetail.apply {
                        text = getString(
                            R.string.price_text,
                            DisplayTools.priceFormatter(data.data.configViewModel.price)
                        )
                        strikeThrough()
                    }
                }

                //seller info
                if (data.data.configViewModel.id == 1) {
                    sellerInfoText_productDetail.text = getString(
                        R.string.seller_info,
                        data.data.configViewModel.seller.fullName
                    )
                } else {
                    if (data.data.configViewModel.sellerRating == 0)
                        sellerInfoText_productDetail.text = getString(
                            R.string.seller_info,
                            data.data.configViewModel.seller.fullName
                        )
                    else
                        sellerInfoText_productDetail.text = getString(
                            R.string.seller_info_with_detail,
                            data.data.configViewModel.seller.fullName,
                            data.data.configViewModel.sellerRating.toString() + '%'
                        )
                }
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_priceChart -> {
                val intent = Intent(this, ProductPriceCharActivity::class.java)
                intent.putExtras(Bundle().apply { putInt("id", productId) })
                startActivity(intent)
            }
        }
        return false
    }

}