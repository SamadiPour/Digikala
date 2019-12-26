package ir.samadipour.digikala.service.utils

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*
import kotlin.NoSuchElementException

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> List<T>.midElement(): T {
    if (isEmpty())
        throw NoSuchElementException("List is empty.")
    return this[size / 2]
}

//toast
fun Context.toast(message: Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun Context.longToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Context.longToast(message: Int) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
fun Fragment.toast(message: Int): Unit = activity!!.toast(message)
fun Fragment.toast(message: CharSequence): Unit = activity!!.toast(message)
fun Fragment.longToast(message: Int): Unit = activity!!.longToast(message)
fun Fragment.longToast(message: CharSequence): Unit = activity!!.longToast(message)

fun <T : ViewModel> Fragment.getViewModel(modelClass: Class<T>): T {
    return ViewModelProvider(this).get(modelClass)
}

fun <T : ViewModel> AppCompatActivity.getViewModel(modelClass: Class<T>): T {
    return ViewModelProvider(this).get(modelClass)
}

fun Activity.hideKeyboard() {
    if (currentFocus != null) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

fun Fragment.hideSoftKeyboard() {
    activity?.hideKeyboard()
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun View.switchVisibility() {
    visibility = if (visibility == View.GONE || visibility == View.INVISIBLE)
        View.VISIBLE
    else
        View.GONE
}

fun TextView.strickThrout() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun String.parseTime(): String {
    return SimpleDateFormat("HH:mm").format(SimpleDateFormat("H:m", Locale.US).parse(this))
}