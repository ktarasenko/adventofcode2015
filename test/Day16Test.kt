import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day16Test{


    @Test
    fun simple(){
        assertEquals(2, Day16.findSue("Sue x: children: 3, " +
                "cats: 7, " +
                "samoyeds: 2, " +
                "pomeranians: 3, " +
                "akitas: 0, " +
                "vizslas: 0, " +
                "goldfish: 7, " +
                "trees: 1, " +
                "cars: 2, " +
                "perfumes: 1", ("Sue 1: goldfish: 6, trees: 9, akitas: 0\n" +
                "Sue 2: goldfish: 7, trees: 1, akitas: 0").split("\n")))
    }


    @Test
    fun simple2(){
        assertEquals(2, Day16.findSue2("Sue x: children: 3, " +
                "cats: 7, " +
                "samoyeds: 2, " +
                "pomeranians: 3, " +
                "akitas: 0, " +
                "vizslas: 0, " +
                "goldfish: 6, " +
                "trees: 5, " +
                "cars: 2, " +
                "perfumes: 1", ("Sue 1: goldfish: 6, trees: 9, akitas: 0\n" +
                "Sue 2: goldfish: 7, trees: 1, akitas: 0").split("\n")))
    }

    @Test
    fun task(){
        assertEquals(103, Day16.findSue("Sue x: children: 3, " +
                "cats: 7, " +
                "samoyeds: 2, " +
                "pomeranians: 3, " +
                "akitas: 0, " +
                "vizslas: 0, " +
                "goldfish: 5, " +
                "trees: 3, " +
                "cars: 2, " +
                "perfumes: 1", File("input/day16.txt").readLines()))
    }


    @Test
    fun task2(){
        assertEquals(-1, Day16.findSue2("Sue x: children: 3, " +
                "cats: 7, " +
                "samoyeds: 2, " +
                "pomeranians: 3, " +
                "akitas: 0, " +
                "vizslas: 0, " +
                "goldfish: 5, " +
                "trees: 3, " +
                "cars: 2, " +
                "perfumes: 1", File("input/day16.txt").readLines()))
    }
}