import com.sun.org.apache.xpath.internal.operations.Bool

object Day6 {

    fun countLitLights(size : Int, list: List<String>) : Int{
        val a = Array(size, { Array(size, {false})})
        list.forEach {
            val s = it.split(" ")
            when{
                it.startsWith("turn on") -> change(a, parsePair(s[2]), parsePair(s[4]), {true})
                it.startsWith("turn off") -> change(a, parsePair(s[2]), parsePair(s[4]), {false})
                it.startsWith("toggle") -> change(a, parsePair(s[1]), parsePair(s[3]), {!it})
            }
        }
        return a.sumBy { it.sumBy { if(it)1 else 0 } }
    }

    fun countBrightness(size : Int, list: List<String>) : Int{
        val a = Array(size, { Array(size, {0})})
        list.forEach {
            val s = it.split(" ")
            when{
                it.startsWith("turn on") -> changeBrightness(a, parsePair(s[2]), parsePair(s[4]), 1)
                it.startsWith("turn off") -> changeBrightness(a, parsePair(s[2]), parsePair(s[4]), -1)
                it.startsWith("toggle") -> changeBrightness(a, parsePair(s[1]), parsePair(s[3]), 2)
            }
        }
        return a.sumBy { it.sum() }
    }

    private fun changeBrightness(a : Array<Array<Int>>, from: Pair<Int, Int>, to: Pair<Int, Int>, d :Int){
        for (i in from.first..to.first){
            for (j in from.second..to.second){
                a[i][j] = Math.max(0, d + a[i][j])
            }
        }
    }

    private fun change(a : Array<Array<Boolean>>, from: Pair<Int, Int>, to: Pair<Int, Int>, op: (Boolean)->Boolean){
        for (i in from.first..to.first){
            for (j in from.second..to.second){
                a[i][j] = op(a[i][j])
            }
        }
    }

    fun parsePair(p : String): Pair<Int, Int>{
        val s = p.split(",")
        return s[0].toInt() to s[1].toInt()
    }
}