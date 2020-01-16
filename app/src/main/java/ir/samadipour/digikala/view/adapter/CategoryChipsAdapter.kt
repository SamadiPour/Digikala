package ir.samadipour.digikala.view.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.CategoriesData
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.view.activities.CategoryActivity
import kotlinx.android.synthetic.main.item_list_chip_category.view.*

class CategoryChipsAdapter : RecyclerView.Adapter<CategoryChipsAdapter.ChipViewHolder>() {
    private var data = emptyList<CategoriesData>()

    fun submit(newData: List<CategoriesData>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: ChipViewHolder, position: Int) {
        viewHolder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder =
        ChipViewHolder(parent.inflate(R.layout.item_list_chip_category))


    class ChipViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val categoryTitle = view.chipsView_productCategories_title
        private var categoryPosition: Int = -1

        init {
            //when clicking on chip
            //sending position to scroll to that position
            view.setOnClickListener {
                val intent = Intent(view.context, CategoryActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("page", categoryPosition)
                intent.putExtras(bundle)
                startActivity(view.context, intent, null)
            }
        }

        fun bind(category: CategoriesData, position: Int) {
            categoryTitle.text = category.category.title
            categoryPosition = position
        }
    }

}