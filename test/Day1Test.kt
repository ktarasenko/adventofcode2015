import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day1Test{
    @Test
    fun provided() {
        assertEquals(0, Day1.countFloor("(())"))
        assertEquals(0, Day1.countFloor("()()"))
        assertEquals(3, Day1.countFloor("((("))
        assertEquals(3, Day1.countFloor("(()(()("))
        assertEquals(-1, Day1.countFloor("())"))
        assertEquals(-1, Day1.countFloor("))("))
        assertEquals(-1, Day1.countFloor("))("))
        assertEquals(-3, Day1.countFloor(")))"))
        assertEquals(-3, Day1.countFloor(")())())"))
    }

    @Test
    fun provided2() {
        assertEquals(1, Day1.firstBasement(")"))
        assertEquals(5, Day1.firstBasement("()())"))
    }

    @Test
    fun task1() {
        assertEquals(232, Day1.countFloor(File("input/day1.txt").readText()))
    }

    @Test
    fun task2() {
        assertEquals(1782, Day1.firstBasement(File("input/day1.txt").readText()))
    }
}