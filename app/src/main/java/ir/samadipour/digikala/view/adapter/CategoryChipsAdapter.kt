package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.CategoriesData
import ir.samadipour.digikala.service.utils.inflate
import kotlinx.android.synthetic.main.item_list_chip_category.view.*

class CategoryChipsAdapter : RecyclerView.Adapter<CategoryChipsAdapter.ChipViewHolder>() {
    private var data = emptyList<CategoriesData>()

    fun submit(newData: List<CategoriesData>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: ChipViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder =
        ChipViewHolder(parent.inflate(R.layout.item_list_chip_category))


    class ChipViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val categoryTitle = view.chipsView_productCategories_title

        init {
            view.setOnClickListener {
                //todo: open category menu
            }
        }

        fun bind(category: CategoriesData) {
            categoryTitle.text = category.category.title
        }
    }

}