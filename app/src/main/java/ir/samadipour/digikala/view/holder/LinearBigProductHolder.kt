package ir.samadipour.digikala.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.click_listener.ProductClickListener
import ir.samadipour.digikala.service.models.sub_models.Product
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.strikeThrough
import kotlinx.android.synthetic.main.item_list_product_big_linear.view.*


class LinearBigProductHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val context: Context = view.context
    private val imageView = view.productBigLinear_ImageView
    private val persianTitle = view.productBigLinear_persianTitleTextView
    private val englishTitle = view.productBigLinear_englishTitleTextView
    private val topPrice = view.productBigLinear_topPrice
    private val lowPrice = view.productBigLinear_lowPrice
    private val specialBox = view.productBigLinear_specialOfferBox
    private val colorList = view.productBigLinear_colorLinearLayout //todo: implement

    init {
        view.setOnClickListener(ProductClickListener())
    }

    fun bind(product: Product) {
        view.id = product.id
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
}