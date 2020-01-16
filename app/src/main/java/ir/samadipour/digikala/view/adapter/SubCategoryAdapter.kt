package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.SubCategory
import ir.samadipour.digikala.service.utils.inflate
import kotlinx.android.synthetic.main.item_list_sub_category.view.*

class SubCategoryAdapter(private val data: List<SubCategory>) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryHolder =
        SubCategoryHolder(parent.inflate(R.layout.item_list_sub_category))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SubCategoryHolder, position: Int) =
        holder.bind(data[position])

    inner class SubCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.subCategory_title
        private val imageView = view.subCategory_imageView


        fun bind(data: SubCategory) {
            title.text = data.title
            imageView.setImageURI(data.imagePath)
        }
    }
}