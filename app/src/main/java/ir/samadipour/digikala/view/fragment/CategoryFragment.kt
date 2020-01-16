package ir.samadipour.digikala.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.SubCategory
import ir.samadipour.digikala.view.adapter.SubCategoryAdapter
import kotlinx.android.synthetic.main.fragment_category_list.*

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //getting subcategory of main category from bundle
        //there is only a recycler view in each category fragment
        categoryFragment_subCategories.adapter =
            SubCategoryAdapter(
                arguments?.getParcelableArrayList<SubCategory>("cat") as List<SubCategory>
            )
    }
}
