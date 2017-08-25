import org.junit.Assert.*
import org.junit.Test

class Day11Test{

    @Test
    fun provided() {
        assertEquals("abcdffaa", Day11.nextValidPassword("abcdefgh"))
        assertEquals("ghjaabcc", Day11.nextValidPassword("ghijklmn"))

    }

    @Test
    fun test(){
        assertEquals("heqaabcc", Day11.nextValidPassword("abz"))
    }
    @Test
    fun task(){
        assertEquals("hepxxyzz", Day11.nextValidPassword("hepxcrrq"))
        assertEquals("heqaabcc", Day11.nextValidPassword("hepxxyzz"))
    }
}