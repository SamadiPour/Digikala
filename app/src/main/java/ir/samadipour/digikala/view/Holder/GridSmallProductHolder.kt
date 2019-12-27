package ir.samadipour.digikala.view.Holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.sub_models.IncredibleOffer
import ir.samadipour.digikala.service.models.sub_models.Product
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.strikeThrough
import kotlinx.android.synthetic.main.item_list_product_small_grid.view.*


class GridSmallProductHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private val context: Context = view.context
    private val imageView = view.productSmallGrid_imageView
    private val title = view.productSmallGrid_title
    private val topPrice = view.productSmallGrid_topPrice
    private val lowPrice = view.productSmallGrid_lowPrice

    init {
        view.setOnClickListener(this)
    }

    fun bind(incredibleOffer: IncredibleOffer, isGone: Boolean) {
        imageView.setImageURI(incredibleOffer.imagePaths.original)
        title.text = incredibleOffer.title

        if (incredibleOffer.discount > 0) {
            topPrice.visibility = View.VISIBLE
            topPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(incredibleOffer.price)
            )
            topPrice.strikeThrough()
            lowPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(incredibleOffer.price - incredibleOffer.discount)
            )
        } else {
            topPrice.visibility = if (isGone) View.GONE else View.INVISIBLE
            lowPrice.text = context.resources.getString(
                R.string.price_text,
                DisplayTools.priceFormatter(incredibleOffer.price)
            )
        }
    }

    fun bind(product: Product, isGone: Boolean, showDiscounted: Boolean) {
        imageView.setImageURI(product.imagePath)
        title.text = product.faTitle

        if (product.isSpecialOffer && product.minPriceList > 0 && showDiscounted) {
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
            topPrice.visibility = if (isGone) View.GONE else View.INVISIBLE
            if (showDiscounted && product.minPriceList > 0) {
                lowPrice.text = context.resources.getString(
                    R.string.price_text,
                    DisplayTools.priceFormatter(product.minPriceList)
                )
            } else {
                lowPrice.text = context.resources.getString(
                    R.string.price_text,
                    DisplayTools.priceFormatter(product.minPrice)
                )
            }
        }
    }

    override fun onClick(v: View?) {

    }
}