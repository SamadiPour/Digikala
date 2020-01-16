package ir.samadipour.digikala.view.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.internal.view.SupportMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import ir.samadipour.digikala.R
import ir.samadipour.digikala.service.models.PriceChartModel
import ir.samadipour.digikala.service.models.Sery
import ir.samadipour.digikala.service.utils.DisplayTools
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.viewmodel.ProductDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_product_price_char.*

class ProductPriceCharActivity : AppCompatActivity(), Observer<Any?> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_price_char)

        DisplayTools.toolbar(
            this,
            noElevation = true,
            showBack = true,
            showTitle = true,
            title = "نمودار قیمت"
        )

//        val productId = intent.getIntExtra("id", -1)
        val productId = 1964396


        val viewModel = ViewModelProvider(
            this,
            InjectUtils.getProductDetailViewModelInstance()
        ).get(ProductDetailActivityViewModel::class.java)
        viewModel.getPriceChart(productId).observe(this, this)

        chart_priceChart.apply {
            //chart config
            setDrawGridBackground(false)
            description = Description().apply {
                text = ""
            }
            description.isEnabled = false
            setNoDataText("")
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)

            //y axis config
            axisLeft.apply {
                removeAllLimitLines()
                enableGridDashedLine(10.0f, 10.0f, 0.0f)
                setDrawZeroLine(false)
                setDrawLimitLinesBehindData(false)
                gridLineWidth = 0.4f
                gridColor = ContextCompat.getColor(
                    this@ProductPriceCharActivity,
                    R.color.chart_grid
                )
                textColor = ContextCompat.getColor(
                    this@ProductPriceCharActivity,
                    R.color.chart_grid
                )
            }

            extraRightOffset = 35.0f
            axisRight.isEnabled = false
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.textColor = ContextCompat.getColor(
                this@ProductPriceCharActivity,
                R.color.chart_grid
            )
        }
    }

    override fun onChanged(data: Any?) {
        when (data) {
            is PriceChartModel -> {
                if (data.data.series.isNotEmpty()) {
                    setDataToChat(data.data.series[0])
                }

                val adapter = ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    data.data.series.map { it.name }
                )
                productSellers_priceChart.adapter = adapter
                productSellers_priceChart.setOnItemClickListener { _, _, position, _ ->
                    setDataToChat(data.data.series[position])
                }
            }
        }
    }

    private fun setDataToChat(data: Sery) {
        val entries: MutableList<Entry> = ArrayList()
        chart_priceChart.apply {
            data.data.forEach {
                entries.add(
                    Entry(
                        it[0].toFloat(),
                        it[1].toFloat()
                    )
                )
            }
            val dataSet = LineDataSet(entries, "").apply {
                fillAlpha = 110
                fillColor = SupportMenu.CATEGORY_MASK
                enableDashedHighlightLine(10.0f, 5.0f, 0.0f)
                color = ContextCompat.getColor(
                    this@ProductPriceCharActivity,
                    R.color.chart_blue
                )
                setCircleColor(
                    ContextCompat.getColor(
                        this@ProductPriceCharActivity,
                        R.color.chart_blue
                    )
                )
                fillDrawable = ContextCompat.getDrawable(
                    this@ProductPriceCharActivity,
                    R.drawable.fade_blue_gradian
                )
                lineWidth = 1.0f
                circleRadius = 4.0f
                setDrawCircleHole(true)
                valueTextSize = 9.0f
                setDrawFilled(true)
            }
            setData(LineData(dataSet))
            invalidate()
            animateX(1800,Easing.EaseOutBack)
        }
    }
}
