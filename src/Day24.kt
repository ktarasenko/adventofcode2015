object Day24 {


    fun solve(list: List<String>): Long {
        val il = list.map { it.toInt() }.sortedDescending()
        val sum = il.sum() / 4
        val p = allDistributions(sum, il, listOf()).groupBy { it.size }.toList()
        return p.minBy { it.first }!!.second.map { it.fold(1L, { a, it -> a * it }) }.min()!!
    }

    fun allDistributions(sum: Int, list: List<Int>, taken: List<Int>): List<List<Int>> {
        if (sum == 0) {
            return listOf(taken)
        }
        if (sum < 0 || list.isEmpty()) {
            return listOf()
        }
        val res = mutableListOf<List<Int>>()
        var ll = list
        for (c in list) {
            ll = ll.drop(1)
            res.addAll(allDistributions(sum - c, ll, taken + c).filter { it.isNotEmpty() })
        }
        return res

    }

}