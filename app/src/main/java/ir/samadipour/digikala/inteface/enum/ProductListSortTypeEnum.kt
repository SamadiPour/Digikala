package ir.samadipour.digikala.inteface.enum

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class ProductListSortTypeEnum(val value: String) : Parcelable {
    MOST_VIEWED("پر بازدید ترین ها"),
    TOP_SALE("پر فروش ترین ها"),
    DECREMENTAL("قیمت از زیاد به کم"),
    INCREMENTAL("قیمت از کم به زیاد"),
    NEWEST("جدید ترین ها");
//    INCREDIBLE_OFFER("پیشنهاد ویژه دیجیکالا");

    fun getIndex() = when (this) {
        MOST_VIEWED -> 0
        TOP_SALE -> 1
        DECREMENTAL -> 2
        INCREMENTAL -> 3
        NEWEST -> 4
    }

    fun toSingleChoiceItemsText() = when (this) {
        MOST_VIEWED -> "پر بازدیدترین"
        TOP_SALE -> "پرفروش ترین"
        DECREMENTAL -> "قیمت از زیاد به کم"
        INCREMENTAL -> "قیمت از کم به زیاد"
        NEWEST -> "جدیدترین"
    }

    fun getApiSortNumber() = when (this) {
        MOST_VIEWED -> 4
        TOP_SALE -> 7
        DECREMENTAL -> 10
        INCREMENTAL -> 10
        NEWEST -> 1
//        INCREDIBLE_OFFER -> -1
    }

    fun getApiSortConditionNumber() = when (this) {
        INCREMENTAL -> 1
        else -> 0
    }
}