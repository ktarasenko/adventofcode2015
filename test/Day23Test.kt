import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day23Test{

    @Test
    fun provided() {
        assertEquals(2, Day23.solve(("inc a\n" +
                "jio a +2\n" +
                "tpl a\n" +
                "inc a").split("\n")))
    }

    @Test
    fun task() {
        assertEquals(2, Day23.solve(File("input/day23.txt").readLines()))
    }
}