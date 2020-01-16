package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.SizesModel
import ir.samadipour.digikala.service.models.sub_models.Color
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.service.utils.overrideColor
import kotlinx.android.synthetic.main.list_item_product_detail_color.view.*
import kotlinx.android.synthetic.main.list_item_product_detail_size.view.*


class ProductDetailColorSizeAdapter(
    private val data: List<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            1 -> ProductDetailColorHolder(parent.inflate(R.layout.list_item_product_detail_color))
            2 -> ProductDetailSizeHolder(parent.inflate(R.layout.list_item_product_detail_size))
            else -> ProductDetailColorHolder(parent.inflate(R.layout.list_item_product_detail_color))
        }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder) {
            is ProductDetailColorHolder -> viewHolder.bind(data[position] as Color)
            is ProductDetailSizeHolder -> viewHolder.bind(data[position] as SizesModel)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (data[0]) {
            is Color -> 1
            is SizesModel -> 2
            else -> -1
        }

    override fun getItemCount() = data.size

    inner class ProductDetailColorHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val colorText = view.colorText_productDetailColor
        private val colorCircle = view.colorCircle_productDetailColor

        fun bind(colorModel: Color) {
            colorText.text = colorModel.title
            colorCircle.background.overrideColor(
                android.graphics.Color.parseColor(colorModel.hexCode.toString())
            )
        }
    }

    inner class ProductDetailSizeHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val sizeTextView = view.sizeText_productDetailSize
        fun bind(sizesModel: SizesModel) {
            sizeTextView.text = sizesModel.title
        }
    }
}