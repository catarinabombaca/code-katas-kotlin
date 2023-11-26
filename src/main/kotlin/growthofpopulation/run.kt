package growthofpopulation

import kotlin.math.floor
import kotlin.math.roundToInt

fun run(p0: Int, percent: Double, aug: Int, p: Int): Int {
    val initialPopulation = p0.toDouble()
    val percentage = percent/100

    var years = 0
    var currentPopulation = initialPopulation.toInt()

    while (currentPopulation < p) {
        currentPopulation += floor((currentPopulation * percentage) + aug).roundToInt()
        years++
    }

    return years
}