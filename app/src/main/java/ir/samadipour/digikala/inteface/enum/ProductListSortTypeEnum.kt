package ir.samadipour.digikala.inteface.enum

import android.os.Parcelable
import ir.samadipour.digikala.R
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class ProductListSortTypeEnum(val value: String) : Parcelable {
    TOP_SALE("پر فروش ترین ها"),
    MOST_VIEWED("پر بازدید ترین ها"),
    NEWEST("جدید ترین ها"),
    INCREDIBLE_OFFER("پیشنهاد ویژه دیجیکالا");

    fun getApiFilterNumber() = when (this) {
        TOP_SALE -> 7
        MOST_VIEWED -> 4
        NEWEST -> 1
        INCREDIBLE_OFFER -> -1
    }
}