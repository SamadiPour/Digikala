package ir.samadipour.digikala.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.samadipour.digikala.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getIntExtra("id", -1)

    }
}