object Day19 {


    fun allPossibleRepls(m: String, ops: List<Pair<String, String>>): Set<String> = ops.flatMap { possibleRepls(m, it) }.toSet()

    fun countSteps(e: String, m: String, ops: List<Pair<String, String>>): Int {
        val opsM1 = ops.map { it.second to it.first }
        var s = listOf(m)
        var steps = 0
        while (!s.contains(e)){
            s = s.flatMap { allPossibleRepls(it, opsM1) }.toSet().sortedBy { it.length }.take(1000) //Mega optimisation + some luck
            steps++
            println("${s.size} ${s.first().length} ")
        }
        return steps
    }

    private fun possibleRepls(m: String, it: Pair<String, String>): List<String> {
        var i =  m.indexOf(it.first)
        val list = mutableListOf<String>()
        while (i >= 0) {
            list.add(m.take(i) + m.drop(i).replaceFirst(it.first, it.second))
            i = m.indexOf(it.first, i+1)
        }
        return list
    }

}