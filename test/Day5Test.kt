import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day5Test{

    @Test
    fun provided() {
        assertEquals(true, Day5.isNice("ugknbfddgicrmopn"))
        assertEquals(true, Day5.isNice("aaa"))
        assertEquals(false, Day5.isNice("jchzalrnumimnmhp"))
        assertEquals(false, Day5.isNice("haegwjzuvuyypxyu"))
        assertEquals(false, Day5.isNice("dvszwmarrgswjxmb"))
    }

    @Test
    fun provided2() {
        assertEquals(true, Day5.isNice2("qjhvhtzxzqqjkmpb"))
        assertEquals(true, Day5.isNice2("xxyxx"))
        assertEquals(false, Day5.isNice2("uurcxstgmygtbstg"))
        assertEquals(false, Day5.isNice2("ieodomkazucvgmuy"))
    }

    @Test
    fun task() {
        assertEquals(238, File("input/day5.txt").readLines().count { Day5.isNice(it)})
    }

    @Test
    fun task2() {
        assertEquals(238, File("input/day5.txt").readLines().count { Day5.isNice2(it)})
    }
}