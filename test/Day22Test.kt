import org.junit.Assert.*
import org.junit.Test

class Day22Test{

    @Test
    fun provided(){
        assertEquals(173 + 53, Day22.foundMinMana(10 to 250, 13 to 8))
        assertEquals(229+ 113+ 73 + 173+  53, Day22.foundMinMana(10 to 250, 14 to 8))
    }

    @Test
    fun task(){
        assertEquals(1269, Day22.foundMinMana(50 to 500, 58 to 9))
    }
    @Test
    fun task2(){
        assertEquals(1269, Day22.foundMinMana2(50 to 500, 58 to 9))
    }
}