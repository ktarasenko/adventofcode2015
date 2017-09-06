import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day24Test{


    @Test
    fun simple(){
        assertEquals(listOf(listOf(3)), Day24.allDistributions(3, listOf(3), listOf()))
        assertEquals(listOf(listOf(1,2)), Day24.allDistributions(3, listOf(1, 2), listOf()))
        assertEquals(listOf(listOf(1,6), listOf(3,4), listOf(7)), Day24.allDistributions(7, listOf(1, 3, 4, 6, 7), listOf()))
    }

    @Test
    fun provided(){
        assertEquals(99, Day24.solve("1 2 3 4 5 7 8 9 10 11".split(" ")))
    }

    @Test
    fun task(){
        assertEquals(99, Day24.solve(File("input/day24.txt").readLines()))
    }
}