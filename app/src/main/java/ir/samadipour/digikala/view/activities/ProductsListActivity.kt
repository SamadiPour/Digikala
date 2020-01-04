package ir.samadipour.digikala.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearSmoothScroller
import ir.samadipour.digikala.R
import ir.samadipour.digikala.inteface.enum.ProductListArrangeEnum
import ir.samadipour.digikala.inteface.enum.ProductListSortTypeEnum
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.service.utils.OnVerticalScrollListener
import ir.samadipour.digikala.view.adapter.ProductListAdapter
import ir.samadipour.digikala.viewmodel.ProductListActivityViewModel
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsListActivity : AppCompatActivity() {
    private var arrange = 0
    private val adapter = ProductListAdapter(isGone = false, showDiscounted = true, dualFull = true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        val type = intent.extras?.getParcelable<ProductListSortTypeEnum>("type")

        DisplayTools.toolbar(
            this,
            showBasket = true,
            showSearch = true,
            showTitle = true,
            title = type!!.value,
            showBack = true,
            noElevation = true
        )

        val productListActivityViewModel = ViewModelProvider(
            this,
            InjectUtils.getProductListViewModelInstance()
        ).get(ProductListActivityViewModel::class.java)

        //arrange options
        productList_arrangeCard.setOnClickListener {
            arrange = (arrange + 1) % 3
            val arrangeEnum = ProductListArrangeEnum.values()[arrange]
            productList_arrangeImage.setImageResource(arrangeEnum.getDrawable())
            productList_productRecyclerView.layoutManager = arrangeEnum.getLayoutManager(this)
            adapter.changeArrangeTo(arrangeEnum)
        }

        //sort options
        productList_sortCard.setOnClickListener {}

        //recycler view
        productList_productRecyclerView.adapter = adapter
        productList_productRecyclerView.layoutManager =
            ProductListArrangeEnum.values()[arrange].getLayoutManager(this)

        //get from api based on type
        productListActivityViewModel.getInfiniteProductSortBasedInitial(type)
        productListActivityViewModel.data.observe(this, Observer {
            if (it != null) {
                adapter.submit(it)
                productList_loadingProgressBar.visibility = View.INVISIBLE
            }
        })

        //go to top button
        productList_goToTop.setOnClickListener {
            val smoothScroller = object : LinearSmoothScroller(this) {
                override fun getVerticalSnapPreference(): Int = SNAP_TO_START
            }
            smoothScroller.targetPosition = 0
            productList_productRecyclerView.layoutManager?.startSmoothScroll(smoothScroller)
            productList_goToTop.hide()
        }

        //endless scroll
        productList_productRecyclerView.addOnScrollListener(OnVerticalScrollListener(
            reachedBottom = {
                productList_loadingProgressBar.visibility = View.VISIBLE
                productListActivityViewModel.getInfiniteProductSortBased(type)
            },
            scrollingUp = {
                productList_goToTop.show()
            },
            scrollingDown = {
                productList_goToTop.hide()
            },
            reachedTop = {
                productList_goToTop.hide()
            }
        ))
    }
}
