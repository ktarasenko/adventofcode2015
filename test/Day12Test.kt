import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day12Test {

    @Test
    fun provided() {
        assertEquals(6, Day12.getInts("[1,2,3]").sum())
        assertEquals(6, Day12.getInts("{\"a\":2,\"b\":4}").sum())
        assertEquals(3, Day12.getInts("{\"a\":{\"b\":4},\"c\":-1}").sum())
        assertEquals(3, Day12.getInts("[[[3]]]").sum())
        assertEquals(0, Day12.getInts("{\"a\":[-1,1]}").sum())
        assertEquals(0, Day12.getInts("[-1,{\"a\":1}]").sum())
        assertEquals(0, Day12.getInts("[] ").sum())
        assertEquals(0, Day12.getInts("{}").sum())
    }

    @Test
    fun provided2() {
        assertEquals(6, Day12.getIntsSum2("[1,2,3]"))
        assertEquals(4, Day12.getIntsSum2("[1,{\"c\":\"red\",\"b\":2},3]"))
        assertEquals(0, Day12.getIntsSum2("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"))
        assertEquals(6, Day12.getIntsSum2("[1,\"red\",5]"))
    }

    @Test
    fun task() {
        assertEquals(191164, Day12.getInts(File("input/day12.txt").readText()).sum())
    }

    @Test
    fun task2() {
        assertEquals(87842, Day12.getIntsSum2(File("input/day12.txt").readText()))
    }
}