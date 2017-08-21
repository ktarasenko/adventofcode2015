import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day3Test{

    @Test
    fun provided(){
        assertEquals(2, Day3.makeMoves(">"))
        assertEquals(4, Day3.makeMoves("^>v<"))
        assertEquals(2, Day3.makeMoves("^v^v^v^v^v"))
    }

    @Test
    fun provided2(){
        assertEquals(3, Day3.makeMoves2(">v"))
        assertEquals(3, Day3.makeMoves2("^>v<"))
        assertEquals(11, Day3.makeMoves2("^v^v^v^v^v"))
    }

    @Test
    fun task1(){
        assertEquals(2565, Day3.makeMoves(File("input/day3.txt").readText()))
    }

    @Test
    fun task2(){
        assertEquals(2639, Day3.makeMoves2(File("input/day3.txt").readText()))
    }
}