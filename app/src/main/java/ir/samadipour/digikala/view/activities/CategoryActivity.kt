package ir.samadipour.digikala.view.activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.view.adapter.CategoryViewPagerAdapter
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val position = intent.extras?.getInt("page") ?: -1

        DisplayTools.toolbar(
            this,
            showBack = true,
            showTitle = true,
            title = "دسته بندی محصولات"
        )

        //check if data reached
        if (CategoryViewModel.data.value != null)
            setTabsTitle(CategoryViewModel.data.value!!, position)
        else {
            CategoryViewModel.data.observe(this, Observer {
                setTabsTitle(it, position)
            })
        }
    }

    private fun setTabsTitle(
        categoriesModel: CategoriesModel,
        position: Int
    ) {
        //creating categories tabs
        //every page is a fragment
        categoryActivity_viewPager.adapter = CategoryViewPagerAdapter(
            supportFragmentManager, lifecycle, categoriesModel.data
        )

        //attaching it to view pager 2
        TabLayoutMediator(categoryActivity_tabLayout, categoryActivity_viewPager) { tab, position ->
            tab.text = categoriesModel.data[position].category.title
        }.attach()

        if (position > 0) {
            //if category was selected by chip
            categoryActivity_tabLayout.getTabAt(position)?.select()
        } else {
            //fixing rtl problem
            categoryActivity_tabLayout.getTabAt(1)?.select()
            Handler().postDelayed({
                categoryActivity_tabLayout.getTabAt(0)?.select()
            }, 20)
        }
    }
}
