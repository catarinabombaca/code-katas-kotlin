package alternatecapitalization

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RunKtTest {
    @Test
    fun `when given a 'a' string return a list of 'A' and 'a'`() {
        val testString = "a"
        val expectedResult = listOf("A", "a")

        val actualResult = run(testString)

        assertEquals(expectedResult, actualResult)
    }
    @Test
    fun `when given a 'abcdef' string return a list of 'AbCdEf' and 'aBcDeF'`() {
        val testString = "abcdef"
        val expectedResult = listOf("AbCdEf", "aBcDeF")

        val actualResult = run(testString)

        assertEquals(expectedResult, actualResult)
    }
}