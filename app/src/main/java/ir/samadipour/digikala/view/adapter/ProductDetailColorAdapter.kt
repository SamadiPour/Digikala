package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.Color
import ir.samadipour.digikala.service.utils.inflate
import ir.samadipour.digikala.service.utils.overrideColor
import kotlinx.android.synthetic.main.list_item_product_detail_color.view.*


class ProductDetailColorAdapter(
    private var data: List<Color>
) : RecyclerView.Adapter<ProductDetailColorAdapter.ProductDetailColorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailColorHolder =
        ProductDetailColorHolder(parent.inflate(R.layout.list_item_product_detail_color))

    override fun onBindViewHolder(viewHolder: ProductDetailColorHolder, position: Int) {
        viewHolder.bind(data[position])
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
}