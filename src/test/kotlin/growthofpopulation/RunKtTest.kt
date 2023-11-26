package growthofpopulation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RunKtTest {
    @Test
    fun `when growing a population from 1000 to 1000, it will take 0 years`() {
        val p0 = 1000
        val p = 1000
        val expectedYearsToGrow = 0

        val actualYearsToGrow = run(p0, 0.0, 0, p)

        assertEquals(expectedYearsToGrow, actualYearsToGrow)
    }

    @Test
    fun `when growing a population from 1000 to 1020 with a 2ppy increase, it will take 1 year`() {
        val p0 = 1000
        val p = 1020
        val percent = 2.0
        val expectedYearsToGrow = 1

        val actualYearsToGrow = run(p0, percent, 0, p)

        assertEquals(expectedYearsToGrow, actualYearsToGrow)
    }

    @Test
    fun `when growing a population from 1000 to 1200 with a 2ppy increase and 50 influx, it will take 3 years`() {
        val p0 = 1000
        val p = 1200
        val percent = 2.0
        val aug = 50
        val expectedYearsToGrow = 3

        val actualYearsToGrow = run(p0, percent, aug, p)

        assertEquals(expectedYearsToGrow, actualYearsToGrow)
    }
    @Test
    fun `when growing a population from 1500 to 5000 with a 5ppy increase and 100 influx, it will take 15 years`() {
        val p0 = 1000
        val p = 1200
        val percent = 2.0
        val aug = 50
        val expectedYearsToGrow = 3

        val actualYearsToGrow = run(p0, percent, aug, p)

        assertEquals(expectedYearsToGrow, actualYearsToGrow)
    }
    @Test
    fun `when growing a population from 1500000 to 2000000 with a 2,5ppy increase and 10000 influx, it will take 10 years`() {
        val p0 = 1000
        val p = 1200
        val percent = 2.0
        val aug = 50
        val expectedYearsToGrow = 3

        val actualYearsToGrow = run(p0, percent, aug, p)

        assertEquals(expectedYearsToGrow, actualYearsToGrow)
    }
}