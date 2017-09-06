import org.junit.Assert.*
import org.junit.Test

class Day25Test{

    @Test
    fun simple() {
        assertEquals(31916031, Day25.code(20151125))
        assertEquals(31916031, Day25.codeN(2))
        assertEquals(1, Day25.getDayN(1, 1))
        assertEquals(2, Day25.getDayN(2, 1))
        assertEquals(3, Day25.getDayN(1, 2))
        assertEquals(19, Day25.getDayN(3, 4))
    }


    @Test
    fun provided() {
        assertEquals(33511524, Day25.codeN(21))
        assertEquals(77061, Day25.codeN(11))
    }

    @Test
    fun task() {
        assertEquals(-1, Day25.codeN(Day25.getDayN(2947, 3029)))
    }

}