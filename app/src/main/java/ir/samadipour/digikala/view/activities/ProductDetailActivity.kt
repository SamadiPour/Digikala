package ir.samadipour.digikala.view.activities

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
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
import ir.samadipour.digikala.view.adapter.ProductDetailColorAdapter
import ir.samadipour.digikala.viewmodel.ProductDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity(), Observer<Any?> {
    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)


//        val productId = intent.getIntExtra("id", -1)
        val productId = 1964396

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

            }
            is ProductAlbumModel -> {
                val imageSliderAdapter = ImageSliderAdapter(fullScreen = false)
                imageSlider_productDetail.sliderAdapter = imageSliderAdapter
                imageSliderAdapter.submit(data.data.map { it.imagePaths.original })
            }
            is ProductConfigModel -> {
                binding.productConfig = data.data

                //create colors list
                binding.colorRecyclerViewProductDetail.adapter =
                    ProductDetailColorAdapter(data.data.colors)

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
}