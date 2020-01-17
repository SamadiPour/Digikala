package ir.samadipour.digikala

import ir.samadipour.digikala.service.utils.DateTimeTools
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class DateTimeToolsTest {
    private lateinit var now: Calendar
    private lateinit var nextDay: Calendar
    private lateinit var nextDayWithRef: Calendar

    @Before
    fun initial() {
        now = DateTimeTools.getNow()
        nextDay = DateTimeTools.getNextDay()
        nextDayWithRef = DateTimeTools.getNextDay(now)
    }

    @Test
    fun testBeSame() {
        Assert.assertEquals(nextDayWithRef, nextDay)
    }

    @Test
    fun testBeAfterThatDay() {
        assert(nextDay.after(now))
    }

    @Test
    fun testBeInSameDay() {
        Assert.assertEquals(now.get(Calendar.DAY_OF_MONTH), nextDay.get(Calendar.DAY_OF_MONTH))
    }
}
