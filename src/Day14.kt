object Day14 {


    fun parseAndSolve(time: Int, list: Iterable<String>): Int {
       return results(time, list).maxBy{it.second}!!.second
    }

    private fun results(time: Int, list: Iterable<String>): List<Pair<Int, Int>> {
        return list.mapIndexed {i, it ->
            val s = it.split(" ")
            i to distance(time, s[3].toInt(), s[6].toInt(), s[13].toInt())
        }
    }


    fun distance(totalTime: Int, speed: Int, time: Int, rest: Int): Int {
        val runs = totalTime / (time + rest)
        val lastRun = Math.min(totalTime % (time + rest), time)
        return runs * speed * time + lastRun * speed
    }

    fun parseAndSolve2(time: Int, list: List<String>): Int {
        val res = (1..time).flatMap {
            val l = results(it, list).sortedByDescending { it.second }
            l.takeWhile { l.first().second == it.second }.map { it.first }
        }
        return res.groupingBy { it }.eachCount().maxBy { it.value }!!.value
    }

}