import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day6Test{

    @Test
    fun provided(){
        assertEquals(1000* 1000, Day6.countLitLights(1000, listOf("turn on 0,0 through 999,999")))
        assertEquals(1000*999, Day6.countLitLights(1000, listOf("turn on 0,0 through 999,999", "toggle 0,0 through 999,0")))
        assertEquals(0, Day6.countLitLights(1000, listOf("turn off 499,499 through 500,500")))
    }


    @Test
    fun task() {
        assertEquals(543903, (Day6.countLitLights(1000, File("input/day6.txt").readLines())))
    }


    @Test
    fun task2() {
        assertEquals(543903, (Day6.countBrightness(1000, File("input/day6.txt").readLines())))
    }


    @Test
    fun provided2() {
        assertEquals(1, Day6.countBrightness(1000, listOf("turn on 0,0 through 0,0")))
        assertEquals(2000000, Day6.countBrightness(1000, listOf("toggle 0,0 through 999,999")))
    }



}
