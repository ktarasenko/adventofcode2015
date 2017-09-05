import org.junit.Assert.*
import org.junit.Test

class Day20Test{

    @Test
    fun provided(){
        assertEquals(1, Day20.solve1({i -> i == 10}))
        assertEquals(2, Day20.solve1({i -> i == 30}))
        assertEquals(3, Day20.solve1({i -> i == 40}))
        assertEquals(4, Day20.solve1({i -> i ==  70}))
        assertEquals(5, Day20.solve1({i -> i == 60}))
        assertEquals(6, Day20.solve1({i -> i == 120}))
        assertEquals(7, Day20.solve1({i -> i == 80}))
        assertEquals(8, Day20.solve1({i -> i == 150}))
        assertEquals(9, Day20.solve1({i -> i == 130}))
    }

    @Test
    fun provided2(){
        assertEquals(1, Day20.solve2({i -> i == 10}))
        assertEquals(2, Day20.solve2({i -> i == 30}))
        assertEquals(3, Day20.solve2({i -> i == 40}))
        assertEquals(4, Day20.solve2({i -> i ==  70}))
        assertEquals(5, Day20.solve2({i -> i == 60}))
        assertEquals(6, Day20.solve2({i -> i == 120}))
        assertEquals(7, Day20.solve2({i -> i == 80}))
        assertEquals(8, Day20.solve2({i -> i == 150}))
        assertEquals(9, Day20.solve2({i -> i == 130}))
    }

    @Test
    fun task(){
        assertEquals(786240, Day20.solve1({i -> i > 34000000}))
    }
    @Test
    fun task2(){
        assertEquals(786240, Day20.solve2({i -> i > 34000000}))
    }
}