object Day18 {


    fun solve(blinks : Int, list : List<String>): Int {
        var arr = parseArray(list)
        repeat(blinks, {arr = blink(arr)})
        return arr.sumBy { it.sumBy { if (it) 1 else 0 } }
    }

    fun solve2(blinks : Int, list : List<String>): Int {
        var arr = parseArray(list)
        stick(arr)
        repeat(blinks, {arr = blink(arr); stick(arr)})
        return arr.sumBy { it.sumBy { if (it) 1 else 0 } }
    }

    private fun stick(arr: Array<Array<Boolean>>) {
        arr[0][arr.size-1] = true
        arr[0][0] = true
        arr[arr.size-1][0] = true
        arr[arr.size-1][arr.size-1] = true
    }

    private fun parseArray(list: List<String>): Array<Array<Boolean>> {
        return Array(list.size, {i -> Array(list.size, {j -> list[i][j] == '#'})})
    }


    fun neighbours(curr: Pair<Int, Int>, arr: Array<Array<Boolean>>) =
            listOf(-1 to -1, 0 to -1, 1 to -1, 1 to 0, -1 to 0, -1 to 1, 0 to 1, 1 to 1)
                    .map { arr.getOrNull(curr.first + it.first)?.getOrNull(curr.second + it.second) ?: false }.groupingBy { it }.eachCount()


    fun blink(arr: Array<Array<Boolean>>): Array<Array<Boolean>> =
            Array(arr.size, { i ->
                Array(arr.size, { j ->
                    val n = Day18.neighbours(i to j, arr)
                    if (arr[i][j]) {
                        n[true] in 2..3
                    } else {
                        n[true] == 3
                    }
                })
            })
}