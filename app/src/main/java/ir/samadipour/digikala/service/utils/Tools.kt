package ir.samadipour.digikala.service.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.appbar.AppBarLayout
import ir.samadipour.digikala.R
import kotlinx.android.synthetic.main.toolbar_actionbar.*
import kotlinx.android.synthetic.main.toolbar_actionbar.view.*
import java.text.NumberFormat
import java.util.*
import java.util.concurrent.TimeUnit


object DateTimeTools {
    fun getNextDay(
        calendar: Calendar = getNow()
    ): Calendar = (calendar.clone() as Calendar).apply {
        set(
            get(Calendar.YEAR),
            get(Calendar.MONTH),
            get(Calendar.DATE),
            23,
            59,
            59
        )
    }

    fun getNow() = Calendar.getInstance(TimeZone.getDefault())
}

object InternetTools {
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
            context.toast(context.resources.getString(R.string.no_browser_found))
        }
    }
}

object DisplayTools {
    fun handleCountDownTimer(
        hourView: TextView,
        minuteView: TextView,
        secondView: TextView
    ) {
        val current = Calendar.getInstance(TimeZone.getDefault())
        val nextDate = DateTimeTools.getNextDay()
        object : CountDownTimer(nextDate.timeInMillis - current.timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                //if 24:00:00 occurs?
                if (hours > 24) {
                    hours %= 24
                }
                hourView.text = String.format("%02d", hours)
                minuteView.text = String.format(
                    "%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    )
                )
                secondView.text = String.format(
                    "%02d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )
            }

            override fun onFinish() {

            }
        }.start()
    }

    fun getGridItemWidthSize(parent: Activity, divideBy: Float): Int {
        val displayMetrics = DisplayMetrics()
        parent.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return (displayMetrics.widthPixels / divideBy).toInt()
    }

    fun priceFormatter(price: Int, isRial: Boolean = true): String {
        return NumberFormat.getNumberInstance(Locale("fa"))
            .format(if (isRial) price / 10 else price)
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
        title: String = "",
        titleSize: Float? = null,
        showDigikala: Boolean = false,
        showBack: Boolean = false,
        showHamburger: Boolean = false,
        noElevation: Boolean = false,
        showMenu: Boolean = false
    ) {
        activity.toolbar.let { toolbar ->
            toolbar.apply {
                if (noElevation) {
                    val stateListAnimator = StateListAnimator()
                    stateListAnimator.addState(IntArray(0), ObjectAnimator.ofFloat(0f))
                    (parent as AppBarLayout).stateListAnimator = stateListAnimator
                }
                if (showDigikala) digikalaImage.switchVisibility()
                if (showBasket) basketButton.switchVisibility()
                if (showSearch) searchButton.switchVisibility()
                if (showTitle) {
                    titleTextView.switchVisibility()
                    titleTextView.text = title
                }
                if (titleSize != null) {
                    titleTextView.textSize = titleSize
                }
                if (showBack) {
                    backButton.switchVisibility()
                    backButton.setOnClickListener {
                        activity.onBackPressed()
                    }
                }
                if (showHamburger) menuButton.switchVisibility()
                if (!showMenu) {
                    activity.menuInflater.inflate(R.menu.hamburger_main_item, menu)
                    menu.clear()
                }
            }
        }
    }
}