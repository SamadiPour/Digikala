package ir.samadipour.digikala.service.click_listener

import android.view.View
import ir.samadipour.digikala.service.models.sub_models.Banner
import ir.samadipour.digikala.service.utils.InternetTools

class BannerClickListener(private val bannerModel: Banner) : View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null)
            when (bannerModel.linkType) {
                "URL" -> InternetTools.openBrowserWith(
                    v.context,
                    bannerModel.linkValue
                )
                "ProductList" -> println(bannerModel.linkValue)
            }
    }
}