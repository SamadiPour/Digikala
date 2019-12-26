package ir.samadipour.digikala.service.utils

import android.view.View
import ir.samadipour.digikala.service.models.sub_models.Banner

object BannerClickListener {
    fun onBanner(bannerModel: Banner, view: View) {
        when (bannerModel.linkType) {
            "URL" -> InternetTools.openBrowserWith(view.context, bannerModel.linkValue)
            "ProductList" -> println(bannerModel.linkValue)//todo: implement this
        }
    }
}