import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day7Test{


    @Test
    fun provided() {
        assertEquals(72, Day7.assemble(("123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i").split("\n")).get("d")!!.invoke())
    }

    @Test
    fun task() {
        assertEquals(46065, Day7.assemble(File("input/day7.txt").readLines()).get("a")!!.invoke())
    }

    @Test
    fun task2() {
        assertEquals(14134, Day7.assemble(File("input/day7.txt").readLines() + listOf("46065 -> b") ).get("a")!!.invoke())
    }
}