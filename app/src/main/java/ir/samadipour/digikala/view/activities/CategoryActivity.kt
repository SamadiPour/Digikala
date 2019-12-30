package ir.samadipour.digikala.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.CategoriesModel
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.view.adapter.CategoryViewPagerAdapter
import ir.samadipour.digikala.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.toolbar_actionbar.*
import kotlinx.android.synthetic.main.toolbar_actionbar.view.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        DisplayTools.toolbar(
            this,
            hasElevation = false,
            showBack = true,
            showTitle = true,
            title = "دسته بندی محصولات"
        )

        if (CategoryViewModel.data.value != null)
            setTabsTitle(CategoryViewModel.data.value!!)
        else {
            CategoryViewModel.data.observe(this, Observer {
                setTabsTitle(it)
            })
        }
    }

    private fun setTabsTitle(categoriesModel: CategoriesModel) {
        categoryActivity_viewPager.adapter =
            CategoryViewPagerAdapter(supportFragmentManager, lifecycle, categoriesModel.data)
        TabLayoutMediator(categoryActivity_tabLayout, categoryActivity_viewPager) { tab, position ->
            tab.text = categoriesModel.data[position].category.title
        }.attach()

        println("sadas")
    }
}
