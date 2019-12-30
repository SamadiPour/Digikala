package ir.samadipour.digikala.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.SubCategory
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.view.holder.SubCategoryHolder

class SubCategoryAdapter(private val data: List<SubCategory>) :
    RecyclerView.Adapter<SubCategoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryHolder =
        SubCategoryHolder(parent.inflate(R.layout.item_list_sub_category))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SubCategoryHolder, position: Int) =
        holder.bind(data[position])
}