import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day18Test{

    @Test
    fun provided(){
        assertEquals(4, Day18.solve(4, (".#.#.#\n" +
                "...##.\n" +
                "#....#\n" +
                "..#...\n" +
                "#.#..#\n" +
                "####..").split("\n")))
    }

    @Test
    fun provided2(){
        assertEquals(17, Day18.solve2(5, ("##.#.#\n" +
                "...##.\n" +
                "#....#\n" +
                "..#...\n" +
                "#.#..#\n" +
                "####.#").split("\n")))
    }

    @Test
    fun task2(){
        assertEquals(821, Day18.solve2(100, File("input/day18.txt").readLines()))
    }

    @Test
    fun task(){
        assertEquals(886, Day18.solve(100, File("input/day18.txt").readLines()))
    }
}