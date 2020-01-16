package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.view.SimpleDraweeView
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.utils.inflate
import kotlinx.android.synthetic.main.item_list_simple_image.view.*


class ImageSliderAdapter(private var fullScreen: Boolean) :
    SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {
    private var data = emptyList<String>()

    fun submit(newData: List<String>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH =
        SliderAdapterVH(parent.inflate(R.layout.item_list_simple_image))

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.bind(data[position])
    }

    override fun getCount(): Int = data.size

    inner class SliderAdapterVH(view: View) : ViewHolder(view) {
        private val imageView: SimpleDraweeView = view.itemList_imageView_large

        fun bind(image: String) {
            imageView.setImageURI(image)
            imageView.hierarchy.actualImageScaleType = if (fullScreen)
                ScalingUtils.ScaleType.CENTER_CROP
            else
                ScalingUtils.ScaleType.CENTER_INSIDE
        }
    }
}