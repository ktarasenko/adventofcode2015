import org.junit.Assert.*
import org.junit.Test

class Day21Test{


    @Test
    fun simple(){
        assertEquals(true, Day21.isWinning(Triple(8, 5, 5), Triple(12, 7, 2)))
    }

    @Test
    fun task(){
        assertEquals(-1, Day21.findCombination(100, Triple(100, 8, 2)))
    }

    @Test
    fun task2(){
        assertEquals(-1, Day21.findCombination2(100, Triple(100, 8, 2)))
    }
}