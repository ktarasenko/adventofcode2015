import org.junit.Assert.*
import org.junit.Test

class Day14Test{

    @Test
    fun provided(){
        assertEquals(1120, Day14.parseAndSolve(1000, ("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.").split("\n")))
    }
    @Test
    fun provided2(){
        assertEquals(689, Day14.parseAndSolve2(1000, ("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.").split("\n")))
        assertEquals(139, Day14.parseAndSolve2(140, ("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.").split("\n")))
        assertEquals(2, Day14.parseAndSolve2(2, ("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.").split("\n")))
    }

    @Test
    fun task(){
        assertEquals(2640, Day14.parseAndSolve(2503, ("Dancer can fly 27 km/s for 5 seconds, but then must rest for 132 seconds.\n" +
                "Cupid can fly 22 km/s for 2 seconds, but then must rest for 41 seconds.\n" +
                "Rudolph can fly 11 km/s for 5 seconds, but then must rest for 48 seconds.\n" +
                "Donner can fly 28 km/s for 5 seconds, but then must rest for 134 seconds.\n" +
                "Dasher can fly 4 km/s for 16 seconds, but then must rest for 55 seconds.\n" +
                "Blitzen can fly 14 km/s for 3 seconds, but then must rest for 38 seconds.\n" +
                "Prancer can fly 3 km/s for 21 seconds, but then must rest for 40 seconds.\n" +
                "Comet can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.\n" +
                "Vixen can fly 18 km/s for 5 seconds, but then must rest for 84 seconds.").split("\n")))
    }

    @Test
    fun task2(){
        assertEquals(2336, Day14.parseAndSolve2(2503, ("Dancer can fly 27 km/s for 5 seconds, but then must rest for 132 seconds.\n" +
                "Cupid can fly 22 km/s for 2 seconds, but then must rest for 41 seconds.\n" +
                "Rudolph can fly 11 km/s for 5 seconds, but then must rest for 48 seconds.\n" +
                "Donner can fly 28 km/s for 5 seconds, but then must rest for 134 seconds.\n" +
                "Dasher can fly 4 km/s for 16 seconds, but then must rest for 55 seconds.\n" +
                "Blitzen can fly 14 km/s for 3 seconds, but then must rest for 38 seconds.\n" +
                "Prancer can fly 3 km/s for 21 seconds, but then must rest for 40 seconds.\n" +
                "Comet can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.\n" +
                "Vixen can fly 18 km/s for 5 seconds, but then must rest for 84 seconds.").split("\n")))
    }
}