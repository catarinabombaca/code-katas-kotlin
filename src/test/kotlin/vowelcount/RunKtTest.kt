package vowelcount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RunKtTest {

    @Test
    fun `when given 'a' string return the number of vowels in it`() {
        val stringWithVowel = "a"
        val expectedResult = 1

        val actualResult = run(stringWithVowel)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `when given 'abc' string return the number of vowels in it`() {
        val stringWithVowelAndConsonant = "abc"
        val expectedResult = 1

        val actualResult = run(stringWithVowelAndConsonant)

        assertEquals(expectedResult, actualResult)
    }
}