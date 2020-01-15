package ir.samadipour.digikala.service.ClickListener

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import ir.samadipour.digikala.view.activities.ProductDetailActivity

class ProductClickListener(private val id: Int) : View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            val intent = Intent(v.context, ProductDetailActivity::class.java)
            val bundle = Bundle().apply { putInt("id", id) }
            intent.putExtras(bundle)
            v.context.startActivity(intent)
        }
    }
}