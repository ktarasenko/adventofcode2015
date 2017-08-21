import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day2Test{

    @Test
    fun provided1(){
        assertEquals(43, Day2.countWrappingSizes(listOf("1x1x10")))
        assertEquals(58, Day2.countWrappingSizes(listOf("2x3x4")))
    }

    @Test
    fun provided2(){
        assertEquals(34, Day2.countRibbonSizes(listOf("2x3x4")))
        assertEquals(14, Day2.countRibbonSizes(listOf("1x1x10")))
    }

    @Test
    fun task1(){
        assertEquals(1588178, Day2.countWrappingSizes(File("input/day2.txt").readLines()))
    }

    @Test
    fun task2(){
        assertEquals(58, Day2.countRibbonSizes(File("input/day2.txt").readLines()))
    }
}