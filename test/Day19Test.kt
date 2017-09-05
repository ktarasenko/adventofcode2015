import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day19Test{

    @Test
    fun provided(){
        val providedMap = listOf("H" to "HO", "H" to "OH", "O" to "HH")
        assertEquals(4, Day19.allPossibleRepls("HOH", providedMap).size)
        assertEquals(3, Day19.allPossibleRepls("H2O", providedMap).size)
        assertEquals(7, Day19.allPossibleRepls("HOHOHO", providedMap).size)
    }

    @Test
    fun provided2(){
        val providedMap = listOf("e" to "O", "e" to "H", "H" to "HO", "H" to "OH", "O" to "HH")
        assertEquals(3, Day19.countSteps("e", "HOH", providedMap)  )
        assertEquals(6, Day19.countSteps("e", "HOHOHO", providedMap))
    }

    @Test
    fun task(){
        assertEquals(-1, Day19.allPossibleRepls("ORnPBPMgArCaCaCaSiThCaCaSiThCaCaPBSiRnFArRnFArCaCaSiThCaCaSiThCaCaCaCaCaCaSiRnFYFArSiRnM" +
                "gArCaSiRnPTiTiBFYPBFArSiRnCaSiRnTiRnFArSiAlArPTiBPTiRnCaSiAlArCaPTiTiBPMgYFArPTiRnFArSiRnCaCaFArRnCaFArCaSiRnSiRnMgArFYCaSiRnMgArCaCaSiThPRnFAr" +
                "PBCaSiRnMgArCaCaSiThCaSiRnTiMgArFArSiThSiThCaCaSiRnMgArCaCaSiRnFArTiBPTiRnCaSiAlArCaPTiRnFArPBPBCaCaSiThCaPBSiThPRnFArSiThCaSiThCaSiThCaPTiBSiRnFYFArC" +
                "aCaPRnFArPBCaCaPBSiRnTiRnFArCaPRnFArSiRnCaCaCaSiThCaRnCaFArYCaSiRnFArBCaCaCaSiThFArPBFArCaSiRnFArRnCaCaCaFArSiRnFArTiRnPMgArF", readMap(File("input/day19.txt").readLines())).size)
    }

    @Test
    fun task2(){
        assertEquals(207, Day19.countSteps("e", "ORnPBPMgArCaCaCaSiThCaCaSiThCaCaPBSiRnFArRnFArCaCaSiThCaCaSiThCaCaCaCaCaCaSiRnFYFArSiRnM" +
                "gArCaSiRnPTiTiBFYPBFArSiRnCaSiRnTiRnFArSiAlArPTiBPTiRnCaSiAlArCaPTiTiBPMgYFArPTiRnFArSiRnCaCaFArRnCaFArCaSiRnSiRnMgArFYCaSiRnMgArCaCaSiThPRnFAr" +
                "PBCaSiRnMgArCaCaSiThCaSiRnTiMgArFArSiThSiThCaCaSiRnMgArCaCaSiRnFArTiBPTiRnCaSiAlArCaPTiRnFArPBPBCaCaSiThCaPBSiThPRnFArSiThCaSiThCaSiThCaPTiBSiRnFYFArC" +
                "aCaPRnFArPBCaCaPBSiRnTiRnFArCaPRnFArSiRnCaCaCaSiThCaRnCaFArYCaSiRnFArBCaCaCaSiThFArPBFArCaSiRnFArRnCaCaCaFArSiRnFArTiRnPMgArF", readMap(File("input/day19.txt").readLines())))
    }

    private fun readMap(lines: List<String>): List<Pair<String, String>> {
       return lines.map {
            with(it.split(" => ")){
                get(0) to get(1)
            }
        }
    }
}