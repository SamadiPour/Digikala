package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.BannerSliderData
import ir.samadipour.digikala.service.utils.InternetTools
import ir.samadipour.digikala.service.utils.inflate
import kotlinx.android.synthetic.main.item_list_simple_image.view.*


class ImageSliderAdapter : SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {
    private var data = emptyList<BannerSliderData>()

    fun submit(newData: List<BannerSliderData>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH =
        SliderAdapterVH(parent.inflate(R.layout.item_list_simple_image))

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.bind(data[position])
    }

    override fun getCount(): Int = data.size

    inner class SliderAdapterVH(private val view: View) : ViewHolder(view) {
        private val imageView: SimpleDraweeView = view.itemList_imageView

        fun bind(banner: BannerSliderData) {
            imageView.apply {
                hierarchy.setPlaceholderImage(R.drawable.ic_dk)
//                setImageURI(banner.bannerPathMobile)
            }


            imageView.setOnClickListener {
                when (banner.bannerType) {
                    "URL" -> InternetTools.openBrowserWith(view.context, banner.linkValue)
//                    "ProductList" -> todo: implement this
                    else -> return@setOnClickListener
                }
            }
        }
    }
}