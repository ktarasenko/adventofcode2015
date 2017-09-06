object Day23 {


    val registers = mutableMapOf("a" to 1, "b" to 0)


    fun solve(list: List<String>): Int {
        process(list.toMutableList())
        return registers["b"]!!
    }

    private fun process(list: MutableList<String>) {
        var i = 0
        while (i < list.size) {
            val cmd = list[i].split(" ")
            when (cmd[0]) {
                "hlf" -> {
                    registers.put(cmd[1],  registers.getOrDefault(cmd[1], 0)/2)
                    i++
                }
                "tpl" -> {
                    registers.put(cmd[1],  registers.getOrDefault(cmd[1], 0)*3)
                    i++
                }
                "inc" -> {
                    registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) + 1);
                    i++
                }
                "jmp" -> i += cmd[1].toInt()
                "jie" -> if (registers.getOrDefault(cmd[1], 0) % 2 == 0) i += cmd[2].toInt() else i++
                "jio" -> if (registers.getOrDefault(cmd[1], 0)  == 1) i += cmd[2].toInt() else i++
            }
        }
    }


}