package ir.samadipour.digikala

import ir.samadipour.digikala.service.utils.DisplayTools
import org.junit.Assert
import org.junit.Test

class DisplayToolsTest {

    @Test
    fun testPriceFormatterDigits() {
        val price = 1234056789
        Assert.assertFalse(
            DisplayTools.priceFormatter(price, false).contains("[0-9]")
        )
    }


    @Test
    fun testPriceFormatterDots() {
        var price: Int
        var expectedDot: Int


        price = 0
        expectedDot = 0
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 1
        expectedDot = 0
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 10
        expectedDot = 0
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 100
        expectedDot = 0
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 10000
        expectedDot = 1
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 1000000
        expectedDot = 2
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )

        price = 1000000
        expectedDot = 1
        Assert.assertEquals(
            DisplayTools.priceFormatter(price).split(',').size,
            expectedDot + 1
        )

        price = 1000000000
        expectedDot = 3
        Assert.assertEquals(
            DisplayTools.priceFormatter(price, false).split(',').size,
            expectedDot + 1
        )
    }
}