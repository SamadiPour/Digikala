package ir.samadipour.digikala.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.IncredibleOffer
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.view.holder.GridSmallProductHolder


class SpecialOfferAdapter(var data: List<IncredibleOffer>) :
    RecyclerView.Adapter<GridSmallProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridSmallProductHolder =
        GridSmallProductHolder(parent.inflate(R.layout.item_list_product_small_grid))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GridSmallProductHolder, position: Int) =
        holder.bind(data[position], false)
}