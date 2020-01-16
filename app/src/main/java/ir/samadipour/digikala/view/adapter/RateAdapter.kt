package ir.samadipour.digikala.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.RateFactorInfo
import ir.samadipour.digikala.service.utils.inflate
import kotlinx.android.synthetic.main.item_list_product_rate.view.*


class RateAdapter(var data: List<RateFactorInfo>) : RecyclerView.Adapter<RateAdapter.RateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateHolder =
        RateHolder(parent.inflate(R.layout.item_list_product_rate))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RateHolder, position: Int) =
        holder.bind(data[position])

    inner class RateHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val rateTitle = view.title_productRate
        private val rateList = listOf(
            view.first_productRate,
            view.second_productRate,
            view.third_productRate,
            view.forth_productRate,
            view.fifth_productRate
        )

        fun bind(data: RateFactorInfo) {
            rateTitle.text = data.title
            var rate = data.rateAverage
            var index = 0
            while (rate > 0) {
                if (rate > 20)
                    rateList[index].progress = 20
                else
                    rateList[index].progress = rate.toInt()
                rate -= 20
                index++
            }
        }
    }
}