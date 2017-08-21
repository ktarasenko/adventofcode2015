import org.junit.Assert.*
import org.junit.Test

class Day4Test{

    @Test
    fun provided(){
        assertEquals(609043, Day4.findLowest("abcdef", "0".repeat(5)))
        assertEquals(1048970, Day4.findLowest("pqrstuv", "0".repeat(5)))
    }

    @Test
    fun task(){
        assertEquals(282749, Day4.findLowest("yzbqklnj", "0".repeat(5)))
        assertEquals(9962624, Day4.findLowest("yzbqklnj", "0".repeat(6)))
    }
}