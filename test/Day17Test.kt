import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day17Test{


    @Test
    fun simple(){
        assertEquals(1, Day17.solve(10, listOf("10")))
        assertEquals(1, Day17.solve(15, listOf("10", "5")))
        assertEquals(2, Day17.solve(10, listOf("10", "10")))
        assertEquals(1, Day17.solve(20, listOf("30", "10", "10")))
        assertEquals(3, Day17.solve(3, listOf("3", "3", "3")))
    }


    @Test
    fun provided(){
        assertEquals(4, Day17.solve(25, listOf("20","15", "10", "5", "5")))
    }

    @Test
    fun task(){
        assertEquals(1638, Day17.solve(150, File("input/day17.txt").readLines()))
    }


    @Test
    fun provided2(){
        assertEquals(3, Day17.solve2(25, listOf("20","15", "10", "5", "5")))
    }

    @Test
    fun task2(){
        assertEquals(17, Day17.solve2(150, File("input/day17.txt").readLines()))
    }
}