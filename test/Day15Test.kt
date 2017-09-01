import org.junit.Assert.*
import org.junit.Test

class Day15Test {


    @Test
    fun provided() {
        assertEquals(62842880, Day15.findBestCookie(("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n" +
                "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3").split("\n")))
    }


    @Test
    fun provided2() {
        assertEquals(57600000, Day15.findBestCookieCalories(("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n" +
                "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3").split("\n")))
    }


    @Test
    fun task(){
        assertEquals(222870, Day15.findBestCookie(("Sugar: capacity 3, durability 0, flavor 0, texture -3, calories 2\n" +
                "Sprinkles: capacity -3, durability 3, flavor 0, texture 0, calories 9\n" +
                "Candy: capacity -1, durability 0, flavor 4, texture 0, calories 1\n" +
                "Chocolate: capacity 0, durability 0, flavor -2, texture 2, calories 8").split("\n")))
    }

    @Test
    fun task2 (){
        assertEquals(117936, Day15.findBestCookieCalories(("Sugar: capacity 3, durability 0, flavor 0, texture -3, calories 2\n" +
                "Sprinkles: capacity -3, durability 3, flavor 0, texture 0, calories 9\n" +
                "Candy: capacity -1, durability 0, flavor 4, texture 0, calories 1\n" +
                "Chocolate: capacity 0, durability 0, flavor -2, texture 2, calories 8").split("\n")))
    }
}