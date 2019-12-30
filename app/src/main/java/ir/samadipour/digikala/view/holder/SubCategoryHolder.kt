package ir.samadipour.digikala.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.service.models.sub_models.SubCategory
import kotlinx.android.synthetic.main.item_list_sub_category.view.*


class SubCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val context: Context = view.context
    private val title = view.subCategory_title
    private val imageView = view.subCategory_imageView


    fun bind(data: SubCategory) {
        title.text = data.title
        imageView.setImageURI(data.imagePath)
    }
}