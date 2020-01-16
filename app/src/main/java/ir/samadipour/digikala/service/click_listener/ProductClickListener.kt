package ir.samadipour.digikala.service.click_listener

import android.content.Intent
import android.os.Bundle
import android.view.View
import ir.samadipour.digikala.view.activities.ProductDetailActivity

class ProductClickListener : View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            val intent = Intent(v.context, ProductDetailActivity::class.java)
            val bundle = Bundle().apply { putInt("id", v.id) }
            intent.putExtras(bundle)
            v.context.startActivity(intent)
        }
    }
}