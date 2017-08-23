import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day8Test{

    @Test
    fun provided(){
        assertEquals(0, Day8.countCharacters(""""""""))
        assertEquals(3, Day8.countCharacters(""""abc""""))
        assertEquals(7, Day8.countCharacters(""""aaa\"aaa""""))
        assertEquals(1, Day8.countCharacters(""""\x27""""))
    }

    @Test
    fun provided2(){
        assertEquals(6, Day8.countEncodedCharacters(""""""""))
        assertEquals(9, Day8.countEncodedCharacters(""""abc""""))
        assertEquals(16, Day8.countEncodedCharacters(""""aaa\"aaa""""))
        assertEquals(11, Day8.countEncodedCharacters(""""\x27""""))
    }


    @Test
    fun task(){
        assertEquals(1371, File("input/day8.txt").readLines().sumBy { it.length - Day8.countCharacters(it)})
    }

    @Test
    fun task2(){
        assertEquals(1371, File("input/day8.txt").readLines().sumBy { Day8.countEncodedCharacters(it)- it.length })
    }
}