package highestandlowest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RunKtTest {
    @Test
    fun `when given a '1' string return the highest and lowest number`() {
        val inputString = "1"
        val expectedResult = "1 1"

        val actualResult = run(inputString)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `when given a '0 1' string return the highest and lowest number`(): Unit {
        val inputString = "0 1"
        val expectedResult = "1 0"

        val actualResult = run(inputString)

        assertEquals(expectedResult, actualResult)
    }
}