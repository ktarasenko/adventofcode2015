object Day13 {


    fun findSeats(list: Iterable<String>): List<Int> {
        val set = HashSet<String>()
        list.forEach{
            val split = it.split(" ")
            set.add(split[0])
            set.add(split[10].dropLast(1))
        }
        val l = set.toList()
        val adjTable = Array(l.size, {i -> Array(l.size, {j -> if (i == j) Int.MIN_VALUE else 0})})
        list.forEach{
            val split = it.split(" ")
            val p1 = l.indexOf(split[0])
            val p2 = l.indexOf(split[10].dropLast(1))
            val d =  (if (split[2] == "lose")-1 else 1) * split[3].toInt()
            adjTable[p1][p2] = d
//            adjTable[p2][p1] = d
        }
        var perm = permutations((0 until l.size).toMutableList(), 0)

        return perm.map { countLength(adjTable, it + it.first()) }
                .filter { it > 0 }
    }


    private fun countLength(adjTable: Array<Array<Int>>, path: List<Int>): Int {
        return (0 until path.size-1).sumBy {
            val nextLength = adjTable[path[it]][path[it+1]] + adjTable[path[it+1]][path[it]]
            if (nextLength == Int.MIN_VALUE) {
                return Int.MIN_VALUE
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