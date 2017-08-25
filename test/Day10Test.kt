import org.junit.Assert.*
import org.junit.Test

class Day10Test{


    @Test
    fun provided(){
        assertEquals("11", Day10.sayAndLook("1"))
        assertEquals("21", Day10.sayAndLook("11"))
        assertEquals("1211", Day10.sayAndLook("21"))
        assertEquals("111221", Day10.sayAndLook("1211"))
        assertEquals("312211", Day10.sayAndLook("111221"))
    }

    @Test
    fun task(){
        assertEquals(4666278, Day10.sayAndLookTimes(50,"3113322113").length)
    }
}