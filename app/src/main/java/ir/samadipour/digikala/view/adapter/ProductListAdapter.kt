package ir.samadipour.digikala.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.inteface.enum.ProductListArrangeEnum
import ir.samadipour.digikala.service.models.dummy_models.Hit
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.view.holder.GridSmallProductHolder
import ir.samadipour.digikala.view.holder.LinearBigProductHolder
import ir.samadipour.digikala.view.holder.LinearSmallProductHolder


class ProductListAdapter(
    private val isGone: Boolean = false,
    private val showDiscounted: Boolean = false,
    private val dualFull: Boolean = false
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = emptyList<Hit>()
    var arrange = ProductListArrangeEnum.TWO_CARD_GRID

    fun submit(newData: List<Hit>) {
        data = newData
        notifyDataSetChanged()
    }

    fun changeArrangeTo(arrangeEnum: ProductListArrangeEnum) {
        arrange = arrangeEnum
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        arrange.viewTypeToHolder(viewType, parent.inflate(arrange.getLayout()), dualFull)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GridSmallProductHolder -> holder.bind(data[position].source, isGone, showDiscounted)
            is LinearSmallProductHolder -> holder.bind(data[position].source)
            is LinearBigProductHolder -> holder.bind(data[position].source)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return arrange.enumToViewType()
    }
}