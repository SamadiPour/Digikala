package ir.samadipour.digikala.view.adapter

import android.content.Context
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InternetTools
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.button.MaterialButton

//
//class VendorsFullListHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
//    private val context: Context = view.context
//    private val productImageView: SimpleDraweeView = view.productImageView
//    private val storeTextView: TextView = view.storeTextView
//    private val priceTextView: TextView = view.priceTextView
//    private val discountedPriceTextView: TextView = view.discountedPriceTextView
//    private val buyButton: MaterialButton = view.buyButton
//    private lateinit var url: String
//
//    init {
//        buyButton.setOnClickListener(this)
//        view.setOnClickListener(this)
//    }
//
//    fun bind(vendors: Vendors) {
//        url = vendors.url
//        productImageView.setImageURI(vendors.vendor.logo)
//        storeTextView.text = vendors.vendor.title
//
//        if (vendors.quantity != 0) { //check if vendor have product
//            priceTextView.text = DisplayTools.priceFormatter(vendors.price)
//
//            if (vendors.discountedPrice != null) {
//                priceTextView.paintFlags =
//                    priceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//                discountedPriceTextView.text = DisplayTools.priceFormatter(vendors.discountedPrice)
//            }
//        } else {
//            priceTextView.text = context.getString(R.string.unavailable)
//        }
//    }
//
//    override fun onClick(v: View?) = InternetTools.openBrowserWith(context, url)
//}