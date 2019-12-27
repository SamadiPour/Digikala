package ir.samadipour.digikala.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.dummy_models.Hit
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.view.Holder.GridSmallProductHolder


class ProductListAdapter(private val isGone: Boolean, private val showDiscounted: Boolean = false) :
    RecyclerView.Adapter<GridSmallProductHolder>() {
    var data = emptyList<Hit>()

    fun submit(newData: List<Hit>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridSmallProductHolder =
        GridSmallProductHolder(parent.inflate(R.layout.item_list_product_small_grid))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GridSmallProductHolder, position: Int) =
        holder.bind(data[position].source, isGone, showDiscounted)
}