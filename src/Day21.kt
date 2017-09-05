object Day21 {

    val weapons = listOf(Triple(8, 4, 0),
            Triple(10, 5, 0),
            Triple(25, 6, 0),
            Triple(40, 7,0),
            Triple(74, 8, 0))
    val armor = listOf(Triple(0, 0, 0),
            Triple(13, 0, 1),
            Triple(31, 0, 2),
            Triple(53, 0, 3),
            Triple(75, 0, 4),
            Triple(102, 0, 5))
    val rings = listOf(
            Triple(0, 0, 0),
            Triple(0, 0, 0),
            Triple(25, 1, 0),
            Triple(50, 2, 0),
            Triple(100, 3, 0),
            Triple(20, 0,1),
            Triple(40, 0, 2),
            Triple(80, 0, 3))



    fun findCombination(hp : Int, boss: Triple<Int, Int, Int>): Int {
        var min = Int.MAX_VALUE
        for (w in 0 until weapons.size){
            for (a in 0 until armor.size){
                for (r1 in 0 until  rings.size){
                    for (r2 in r1+1 until rings.size){
                        val inv = sum(weapons[w], armor[a], rings[r1], rings[r2])
                        if (isWinning(Triple(hp, inv.second, inv.third), boss)){
                            min = Math.min(inv.first, min)
                        }
                    }
                }
            }
        }
        return min
    }


    fun findCombination2(hp : Int, boss: Triple<Int, Int, Int>): Int {
        var max = 0
        for (w in 0 until weapons.size){
            for (a in 0 until armor.size){
                for (r1 in 0 until  rings.size){
                    for (r2 in r1+1 until rings.size){
                        val inv = sum(weapons[w], armor[a], rings[r1], rings[r2])
                        if (!isWinning(Triple(hp, inv.second, inv.third), boss)){
                            max = Math.max(inv.first, max)
                        }
                    }
                }
            }
        }
        return max
    }


    private fun sum(vararg comps:  Triple<Int, Int, Int>): Triple<Int, Int, Int> {
        var s = Triple(0, 0,0)
        comps.forEach { c -> s = Triple(s.first + c.first, s.second + c.second, s.third + c.third) }
        return s
    }

    fun isWinning(me : Triple<Int, Int, Int>, boss : Triple<Int, Int, Int>): Boolean {
        val m = normalize(me, boss)
        val b  = normalize(boss, me)
        return stepsToDefeat(m, b) >= stepsToDefeat(b, m)
    }

    private fun stepsToDefeat(m: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        return Math.ceil(m.first.toDouble() / b.second.toDouble()).toInt()
    }

    private fun normalize(one: Triple<Int, Int, Int>, two: Triple<Int, Int, Int>): Pair<Int, Int> {
        return one.first to Math.max(1, one.second - two.third)
    }
}