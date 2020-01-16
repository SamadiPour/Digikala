package ir.samadipour.digikala.view.adapter

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.samadipour.digikala.service.models.CategoriesData
import ir.samadipour.digikala.view.fragment.CategoryFragment
import java.util.*

class CategoryViewPagerAdapter(
    fragment: FragmentManager,
    lifecycle: Lifecycle,
    private val data: List<CategoriesData>
) : FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment {
        //sending subcategories to fragment
        val fragment = CategoryFragment()
        fragment.arguments = Bundle().apply {
            putParcelableArrayList("cat", data[position].subCategory as ArrayList<out Parcelable>)
        }
        return fragment
    }

}