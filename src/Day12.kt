object Day12 {



    fun getInts(s : String): Iterable<Int>{
        return """-?\d+""".toRegex().findAll(s).asIterable().map { it.value.toInt() }
    }

    fun getIntsSum2(s : String): Int{
        return if (s.startsWith("[") && s.endsWith("]")){
           getArrayElements(s.substring(1, s.length-1)).sumBy{getIntsSum2(it)}
        } else if (s.startsWith("{") && s.endsWith("}")){
            val v = getObjectElements((s.substring(1, s.length-1)))
            if (!v.contains("\"red\"")) v.sumBy { getIntsSum2(it) } else 0
        } else {
            s.toIntOrNull() ?: 0
        }
    }

    private fun getObjectElements(s: String): List<String> {
        val list = mutableListOf<String>()
        var i = 0
        while (i < s.length){
            i = s.indexOf(':', i) + 1
            val el = getNextValue(s, i)
            list.add(el)
            i += el.length + 1
        }
        return list
    }

    private fun getNextValue(s: String, start: Int): String {
        return when (s[start]) {
            '[' -> nextToken(s, start, '[', ']')
            '{' -> nextToken(s, start, '{', '}')
            else -> s.drop(start).takeWhile { it != ',' }
        }
    }

    private fun nextToken(s: String, start : Int, from: Char, to: Char): String {
        var c = 0
        return s.drop(start).takeWhile {
            when (it) {
                from -> c++
                to -> c--
            }
            c != 0
        } + to
    }

    private fun getArrayElements(s: String): List<String> {
        val list = mutableListOf<String>()
        var i = 0
        while (i < s.length){
            val t = getNextValue(s, i)
            i += t.length +1
            list.add(t)
         }
        return list
    }

}