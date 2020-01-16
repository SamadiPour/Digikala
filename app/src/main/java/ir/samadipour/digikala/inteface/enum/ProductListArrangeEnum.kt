package ir.samadipour.digikala.inteface.enum

import android.app.Activity
import android.content.Context
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.view.holder.GridSmallProductHolder
import ir.samadipour.digikala.view.holder.LinearBigProductHolder
import ir.samadipour.digikala.view.holder.LinearSmallProductHolder
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.item_list_product_small_grid.view.*

@Parcelize
enum class ProductListArrangeEnum : Parcelable {
    TWO_CARD_GRID, SMALL_LINEAR_CARD, BIG_LINEAR_CARD;

    fun getLayoutManager(context: Context) = when (this) {
        TWO_CARD_GRID -> GridLayoutManager(context, 2)
        SMALL_LINEAR_CARD -> LinearLayoutManager(context)
        BIG_LINEAR_CARD -> LinearLayoutManager(context)
    }

    fun getLayout() = when (this) {
        TWO_CARD_GRID -> R.layout.item_list_product_small_grid
        SMALL_LINEAR_CARD -> R.layout.item_list_product_small_linear
        BIG_LINEAR_CARD -> R.layout.item_list_product_big_linear
    }

    fun getDrawable() = when (this) {
        TWO_CARD_GRID -> R.drawable.ic_arrange_small_grid
        SMALL_LINEAR_CARD -> R.drawable.ic_arrange_big_linear
        BIG_LINEAR_CARD -> R.drawable.ic_arrange_small_linear
    }

    fun enumToViewType() = when (this) {
        TWO_CARD_GRID -> 1
        SMALL_LINEAR_CARD -> 2
        BIG_LINEAR_CARD -> 3
    }

    fun viewTypeToHolder(
        viewType: Int,
        view: View,
        dualFull: Boolean = false
    ): RecyclerView.ViewHolder = when (viewType) {
        1 -> {
            if (dualFull) {
                //scratch view to have 2.1 item in page
                //0.1 is for padding between them
                view.layoutParams.width = DisplayTools.getGridItemWidthSize(
                    view.context as Activity,
                    2.1f
                )
                view.productSmallGrid_cardView.cardElevation = 5f
            }
            GridSmallProductHolder(view)
        }
        2 -> LinearSmallProductHolder(view)
        3 -> LinearBigProductHolder(view)
        else -> GridSmallProductHolder(view)
    }
}