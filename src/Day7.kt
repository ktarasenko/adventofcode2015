object Day7 {

    fun assemble(list: List<String>): MutableMap<String, () -> Int> {
        var map = mutableMapOf<String, () -> Int>()
        list.forEach {
            val s = it.split(" ")
            map[s.last()] = when {
                s[1] == "AND" -> {
                    {registerOrValue(map, s[0]).and(registerOrValue(map, s[2]))}
                }
                s[1] == "OR" -> {
                    {registerOrValue(map, s[0]).or(registerOrValue(map, s[2]))}
                }
                s[1] == "LSHIFT" -> {
                    {registerOrValue(map, s[0]).leftshift(registerOrValue(map, s[2]))}
                }
                s[1] == "RSHIFT" -> {
                    {registerOrValue(map, s[0]).rightshift(registerOrValue(map, s[2]))}
                }
                s[0] == "NOT" -> {
                    {registerOrValue(map, s[1]).not()}
                }
                else -> {
                    {registerOrValue(map, s[0])}
                }
            }
        }

        println(map.toSortedMap().map { it.key to it.value.invoke() })
        return map
    }

    fun registerOrValue(map: MutableMap<String, () -> Int>, s: String): Int {
        val f = map.getOrDefault(s, {s.toIntOrNull() ?: 0}).invoke()
        map[s] = {f}
        return f
    }

}

private fun Int.not(): Int {
    val bits = this.toString(2).takeLast(16).padStart(16, '0').map { if (it == '1') '0' else '1' }.joinToString(separator = "")
    return bits.toInt(2)
}


private fun Int.rightshift(amount: Int): Int {
    val shift = amount % 16
    val bits = this.toString(2).takeLast(16)

    return ("0".repeat(shift) + bits.dropLast(shift)).take(16).toInt(2)
}

private fun Int.leftshift(amount: Int): Int {
    val shift = amount % 16
    val bits = this.toString(2)

    return (bits + "0".repeat(shift).takeLast(16)).toInt(2)
}
