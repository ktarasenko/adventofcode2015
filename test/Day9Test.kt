import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day9Test{

    @Test
    fun provided(){
        assertEquals(605, Day9.shortestWay(("London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141").split("\n")))
    }

    @Test
    fun provided2(){
        assertEquals(982, Day9.longestWay(("London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141").split("\n")))
    }

    @Test
    fun task(){
        assertEquals(251, Day9.shortestWay(File("input/day9.txt").readLines()))
    }

    @Test
    fun task2(){
        assertEquals(898, Day9.longestWay(File("input/day9.txt").readLines()))
    }
}