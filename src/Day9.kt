object Day9 {



    fun shortestWay(list: Iterable<String>): Int{
        return findWays(list).min()!!
    }

    private fun findWays(list: Iterable<String>): List<Int> {
        val set = HashSet<String>()
        list.forEach{
            val split = it.split(" ")
            set.add(split[0])
            set.add(split[2])
        }
        val l = set.toList()
        val adjTable = Array(l.size, {Array(l.size, {-1})})
        list.forEach{
            val split = it.split(" ")
            val p1 = l.indexOf(split[0])
            val p2 = l.indexOf(split[2])
            val d =  split[4].toInt()
            adjTable[p1][p2] = d
            adjTable[p2][p1] = d
        }
        var perm = permutations((0 until l.size).toMutableList(), 0)

        return perm.map { countLength(adjTable, it) }
                .filter { it > 0 }
    }


    fun longestWay(list: List<String>): Int {
        return findWays(list).max()!!
    }




    private fun countLength(adjTable: Array<Array<Int>>, path: List<Int>): Int {
        return (0 until path.size-1).sumBy {
            val nextLength = adjTable[path[it]][path[it+1]]
            if (nextLength == -1) {
                return -1
            }
            nextLength
        }
    }

    fun permutations(list : MutableList<Int>, from : Int): List<List<Int>>{
        val res = mutableListOf<List<Int>>()
        if (from == list.size){
            res.add(ArrayList(list))
        } else {
            for (i in from until list.size){
                swap(list, from, i)
                res.addAll(permutations(list, from +1))
            }
            for (i in from until list.size-1){
                swap(list, i, i+1)
            }
        }
        return res
    }

    private fun swap(list: MutableList<Int>, from: Int, i: Int) {
        val t = list[i]
        list[i] = list[from]
        list[from] = t
    }

}