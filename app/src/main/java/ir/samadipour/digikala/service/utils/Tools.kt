package ir.samadipour.digikala.service.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import ir.samadipour.digikala.R
import kotlinx.android.synthetic.main.toolbar_actionbar.*
import kotlinx.android.synthetic.main.toolbar_actionbar.view.*
import java.text.NumberFormat
import java.util.*


class InternetTools {
    companion object {

        //todo: need some test - http://..., https://..., ://..., wrong url, //..., /...
        fun openBrowserWith(context: Context, url: String) {
            //check if it has scheme like http, https, file and ...
            var finalUrl = url
            if (Uri.parse(url).scheme == null)
                finalUrl = "http://$url"

            //start browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(finalUrl))
            if (browserIntent.resolveActivity(context.packageManager) != null) {
                startActivity(context, browserIntent, null)
            } else {
                //todo: should consider smt else!!!!
                context.toast(context.resources.getString(R.string.no_browser_found))
            }
        }
    }
}

class DisplayTools {
    companion object {
        fun getGridItemHeightSize(parent: Activity, divideBy: Int): Int {
            val displayMetrics = DisplayMetrics()
            parent.windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.heightPixels / divideBy
        }

        fun getGridItemWidthSize(parent: Activity, divideBy: Int): Int {
            val displayMetrics = DisplayMetrics()
            parent.windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.widthPixels / divideBy
        }

        fun priceFormatter(price: Int): String {
            return NumberFormat.getNumberInstance(Locale.getDefault()).format(price)
        }

        fun switchVisibility(
            first: View,
            second: View,
            isAnimated: Boolean = false,
            duration: Long = 300
        ) {
            val firstTemp = first.visibility
            val secondTemp = second.visibility

            if (isAnimated) {
                first.animate()
                    .setDuration(duration)
                    .alpha(if (secondTemp == View.VISIBLE) 1.0f else 0.0f)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            first.visibility = secondTemp
                        }
                    })
                second.animate()
                    .setDuration(duration)
                    .alpha(if (firstTemp == View.VISIBLE) 1.0f else 0.0f)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            second.visibility = firstTemp
                        }
                    })
            } else {
                first.visibility = secondTemp
                second.visibility = firstTemp
            }
        }

        fun toolbar(
            activity: AppCompatActivity,
            showBasket: Boolean = false,
            showSearch: Boolean = false,
            showTitle: Boolean = false,
            showDigikala: Boolean = false,
            showBack: Boolean = false,
            showMenu: Boolean = false
        ) {
            activity.toolbar.apply {
                if (showDigikala) digikalaImage.switchVisibility()
                if (showBasket) basketButton.switchVisibility()
                if (showSearch) searchButton.switchVisibility()
                if (showTitle) titleTextView.switchVisibility()
                if (showBack) backButton.switchVisibility()
                if (showMenu) menuButton.switchVisibility()
            }
        }
    }
}