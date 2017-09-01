object Day16 {

    fun findSue(input: String, list: List<String>): Int {
        val inp = parse(input)
        val sues = list.mapIndexed { i, it -> i + 1 to parse(it) }
        return sues.first { inp.containsAll(it.second) }.first
    }

    fun findSue2(input: String, list: List<String>): Int {
        val inp = parse(input).toMap()
        val sues = list.mapIndexed { i, it -> i + 1 to parse(it) }
        return sues.first {
            it.second.all {
                when (it.first){
                    "cats", "trees" -> inp.get(it.first)!! < it.second
                    "goldfish", "pomeranians" -> inp.get(it.first)!! > it.second
                    else -> inp.get(it.first)  == it.second
                }
            }
        }.first
    }


    private fun parse(sue: String): List<Pair<String, Int>> {
        val s = sue.dropWhile { it != ':' }.drop(2).split(", ")
        return s.map { with(it.split(" ")) { this[0].dropLast(1) to this[1].toInt() } }
    }
}