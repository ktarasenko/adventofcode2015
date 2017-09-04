object Day17 {

    fun solve(liters: Int, containers : List<String>) = countExchanges(0, 0, liters, parseInput(containers)).size

    fun solve2(liters: Int, containers : List<String>) = countExchanges(0,0, liters, parseInput(containers)).groupingBy { it.first }.eachCount().toSortedMap().toList().first().second



    private fun countExchanges(pos: Int, cnt: Int,  liters: Int, containers: Array<Array<Int>>): List<Pair<Int, Int>> {
        if (liters == 0){
            return listOf(cnt to 1)
        }
        if (liters < 0 || pos >= containers.size){
            return listOf()
        }
        var totalCount = cnt
        var currLiters = liters
        var count = countExchanges(pos+1, cnt, currLiters, containers)
        val curVal = containers[pos][0]
        val intialCount = containers[pos][1]
        while (containers[pos][1] > 0){
            val curCount = containers[pos][1]--
            currLiters -= curVal
            totalCount++
            val solutions = countExchanges(pos+1, totalCount, currLiters, containers)
            repeat(curCount, {count +=  solutions})
        }
        containers[pos][1] = intialCount
        return count
    }

    private fun parseInput(containers: List<String>): Array<Array<Int>> =
            containers.map { it.toInt() }.groupingBy { it }.eachCount().toList().sortedByDescending { it.first }.map { it.toList().toTypedArray()}.toTypedArray()
}