package learnxinyminutes

fun run() {
    val fooVal = 10 //we cannot reassign fooVal to something else
    var fooVar = 10
    fooVar = 20 //fooVar can be reassigned

    val foo: Int = 7 //explicitly declaring the variable type

    val fooString = "My String is Here!"
    val barString = "Printing on a new line?\nNo Problem!"
    val bazString = "Do you want to add a tab?\tNo Problem!"

    println(fooString)
    println(barString)
    println(bazString)

    //A raw string is delimited by a triple quote (""")
    val fooRawString = """
fun helloWorld(val name : String) {
   println("Hello, world!")
}
"""
    println(fooRawString)

    val fooTemplateString = "$fooString has ${fooString.length} characters"
    println(fooTemplateString) //a string can contain template expressions

    var fooNullable: String? = "abc" //a var can be nullable
    println(fooNullable?.length) //access a nullable variable
    println(fooNullable?.length ?: -1) //specify an alternative value to use

    fooNullable = null
    println(fooNullable?.length) //null
    println(fooNullable?.length ?: -1) //-1

    fun hello(name: String = "world"): String {
        return "Hello, $name!"
    }
    println(hello("foo"))
    println(hello(name = "bar"))
    println(hello())

    //a fun param can be marked with vararg to allow a variable number of args to be passed
    fun varargExample(vararg names: Int) {
        println("Argument has ${names.size} elements")
    }
    varargExample()
    varargExample(1)
    varargExample(1, 2, 3)

    //if a single expression then the curly brackets can be omitted
    fun odd(x: Int): Boolean = x % 2 == 1
    println(odd(6))
    println(odd(7))

    //if the return type can be inferred then we don't specify it
    fun even(x: Int) = x % 2 == 0
    println(even(6))
    println(even(7))

    //funs can take funs as args and return funs
    fun not(f: (Int) -> Boolean): (Int) -> Boolean {
        return {n -> !f.invoke(n)}
    }

    //named funs can be specified as args using the :: operator
    val notOdd = not(::odd)
    val notEven = not(::even)

    //lambda exp can be specified as args
    val notZero = not {n -> n == 0}

    //if the lambda has only 1 param then its declaration can be omitted
    val notPositive = not { it > 0 }
    for (i in 0..4) {
        println("${notOdd(i)} ${notEven(i)} ${notZero(i)} ${notPositive(1)}")
    }

    class ExampleClass(val x: Int) {
        fun memberFunction(y: Int): Int {
            return x + y
        }

        infix fun infixMemberFunction(y: Int): Int {
            return x * y
        }
    }

    val fooExampleClass = ExampleClass(7) //new instance of the class w/ constructor
    // member funs can be called w/ . notation
    println(fooExampleClass.memberFunction(4))
    //infix funs can be called w/ infix notation
    println(fooExampleClass infixMemberFunction 4)

    data class DataClassExample(val x: Int, val y: Int, val z: Int)
    val fooData = DataClassExample(1,2,4)
    println(fooData)

    val fooCopy = fooData.copy(y = 100)
    println(fooCopy)

    val (a, b, c) = fooCopy //objects can be destructured into multiple vars
    println("$a $b $c")

    for ((a, b, c) in listOf(fooData)) {
        println("$a $b $c") //destructuring in for loop
    }

    val mapData = mapOf("a" to 1, "b" to 2)
    for ((key, value) in mapData) {
        println("$key -> $value") // destructuring a map
    }

    data class MutableDataClassExample (var x: Int, var y: Int, var z: Int)
    val fooMutableData = MutableDataClassExample(7, 4, 9)
    with (fooMutableData) {
        x -= 2
        y += 2
        z--
    }

    println(fooMutableData)

    val fooList = listOf("a", "b", "c")
    println(fooList.size)
    println(fooList.first())
    println(fooList.last())
    println(fooList[1])

    val fooMutableList = mutableListOf("a", "b", "c")
    fooMutableList.add("d")
    println(fooMutableList.last())
    println(fooMutableList.size)

    val fooSet = setOf("a", "b", "c")
    println(fooSet.contains("a"))
    println(fooSet.contains("z"))

    val fooMap = mapOf("a" to 8, "b" to 7, "c" to 9)
    println(fooMap["a"])

    //sequences represent lazily-evaluated collections
    val fooSequence = generateSequence(1, { it + 1 })
    val x = fooSequence.take(10).toList()
    println(x)

    fun fibonacciSequence(): Sequence<Long> {
        var a = 0L
        var b = 1L

        fun next(): Long {
            val result = a + b
            b = result
            return a
        }

        return generateSequence(::next)
    }

    val y = fibonacciSequence().take(10).toList()
    println(y)

    //kotlin provides higher-order funs for working w/ collections
    val z = (1..9)
        .map { it * 3 }
        .filter { it < 20 }
        .groupBy { it % 2 == 0 }
        .mapKeys { if (it.key) "even" else "odd" }

    println(z)

    //a for loop can be used w/ anything that provides an iterator
    for (c in "hello") {
        println(c)
    }

    var ctr = 0
    while (ctr < 5) {
        println(ctr)
        ctr++
    }
    do {
        println(ctr)
        ctr++
    } while (ctr < 10)

    val num = 5
    val message = if (num % 2 == 0) "even" else "odd"
    println("$num is $message")

    val i = 10
    when {
        i < 7 -> println("first block")
        fooString.startsWith("hello") -> println("second block")
        else -> println("else block")
    }

    when (i) {
        0, 21 -> println("0 or 21")
        in 1..20 -> println("in the range 1 to 20")
        else -> println("none of the above")
    }

    var result = when (i) {
        0, 21 -> "0 or 21"
        in 1..20 -> "in the range 1 to 20"
        else -> "none of the above"
    }
    println(result)

    //if an obj passes a type check then it can be used as that type without explicitly castinf it
    fun smartCastExample(x: Any): Boolean {
        if (x is Boolean) {
            return x
        } else if (x is Int) {
            return  x > 0
        } else if (x is String) {
            return x.isNotEmpty()
        } else {
            return false
        }
    }
    println(smartCastExample(""))
    println(smartCastExample(5))
    println(smartCastExample(0))
    println(smartCastExample(true))

    fun smartCastWhenExample(x: Any) = when (x) {
        is Boolean -> x
        is Int -> 0
        is String -> x.isNotEmpty()
        else -> false
    }

    fun String.remove(c: Char): String {
        return this.filter { it != c }
    }
    println("Hello, world!".remove('l'))
}

enum class EnumExample {
    A, B, C
}
fun printEnum() = println(EnumExample.A)

enum class EnumExample1(val value: Int) {
    A(value = 1),
    B(value = 2),
    C(value = 3)
}
fun printProperty() = println(EnumExample1.A.value)

//every enum has properties to obtain its name and ordinal(position) in the enum class declaration
fun printName() = println(EnumExample1.A.name)
fun printPosition() = println(EnumExample1.A.ordinal)

//the 'object' keyword can be used to create singleton objects
//we cannot instantiate it but we can refer to its unique instance by its name
object ObjectExample {
    fun hello(): String {
        return "hello"
    }

    override fun toString(): String {
        return "Hello, it's me, ${ObjectExample::class.simpleName}"
    }
}

fun useSingletonObject() {
    println(ObjectExample.hello())
    val someRef: Any = ObjectExample
    //'any' is the root of the class hierarchy, just like 'object' is in java
    println(someRef)
}

//the not-null assertion !! converts any value to a non-null type and throws an exception if the value is null
var b: String? = "abc"
val l = b!!.length

data class Counter(var value: Int) {
    operator fun plusAssign(increment: Int) {
        this.value += increment
    }

    // overload Counter++ and ++Counter
    operator fun inc() = Counter(value + 1)

    // overload Counter + Counter
    operator fun plus(other: Counter) = Counter(this.value + other.value)

    // overload Counter * Counter
    operator fun times(other: Counter) = Counter(this.value * other.value)

    // overload Counter * Int
    operator fun times(value: Int) = Counter(this.value * value)

    // overload Counter in Counter
    operator fun contains(other: Counter) = other.value == this.value

    // overload Counter[Int] = Int
    operator fun set(index: Int, value: Int) {
        this.value = index + value
    }

    // overload Counter instance invocation
    operator fun invoke() = println("The value of the counter is $value")
}