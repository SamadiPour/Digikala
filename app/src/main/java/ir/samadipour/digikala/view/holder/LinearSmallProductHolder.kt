package ir.samadipour.digikala.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.Product
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.strikeThrough
import kotlinx.android.synthetic.main.item_list_product_small_linear.view.*


class LinearSmallProductHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private val context: Context = view.context
    private val imageView = view.productSmallLinear_ImageView
    private val persianTitle = view.productSmallLinear_persianTitleTextView
    private val englishTitle = view.productSmallLinear_englishTitleTextView
    private val topPrice = view.productSmallLinear_topPrice
    private val lowPrice = view.productSmallLinear_lowPrice
    private val specialBox = view.productSmallLinear_specialOfferBox

    init {
        view.setOnClickListener(this)
    }

    fun bind(product: Product) {
        imageView.setImageURI(product.imagePath)
        persianTitle.text = product.faTitle
        englishTitle.text = product.enTitle
        specialBox.visibility = if (product.isSpecialOffer) View.VISIBLE else View.INVISIBLE

        if (product.isSpecialOffer && product.minPriceList > 0) {
            topPrice.visibility = View.VISIBLE
            topPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(product.minPriceList)
            )
            topPrice.strikeThrough()
            lowPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(product.minPrice)
            )
        } else {
            topPrice.visibility = View.INVISIBLE
            lowPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(product.minPrice)
            )
        }
    }

    override fun onClick(v: View?) {

    }
}