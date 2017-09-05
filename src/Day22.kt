object Day22 {


    fun foundMinMana(me: Pair<Int, Int>, boss: Pair<Int, Int>): Int {
        var g = listOf(Game(0, true, Triple(me.first, 0, me.second), boss, listOf(), listOf()))
        while (g.any { !it.isOver() }) {
            g = g.flatMap { if (it.isOver()) listOf(it) else it.doTurns() }.sortedBy { it.boss.first }.take(10000)
        }
        val r = g.filter { it.isWon() }.minBy { it.manaUsed }!!
        return r.manaUsed

    }

    fun foundMinMana2(me: Pair<Int, Int>, boss: Pair<Int, Int>): Int {
        var g = listOf(Game(0, true, Triple(me.first, 0, me.second), boss,
                listOf( "hard" to Effect(Int.MAX_VALUE, { p, b -> Triple(p.first-1, p.second , p.third) to b })), listOf()))
        while (g.any { !it.isOver() }) {
            g = g.flatMap { if (it.isOver()) listOf(it) else it.doTurns() }.sortedBy { it.boss.first }.take(10000)
        }
        val r = g.filter { it.isWon() }.minBy { it.manaUsed }!!
        return r.manaUsed

    }


    class Game(val manaUsed: Int, val myTurn: Boolean, val player: Triple<Int, Int, Int>, val boss: Pair<Int, Int>, val effects: List<Pair<String, Effect>>, val turns: List<String>) {

        fun doTurns(): List<Game> {
            val g = applyEffects()
            if (!g.isOver()) {
                return if (myTurn) {
                    g.doMyTurns()
                } else {
                    g.doBossTurn()
                }
            }
            return listOf(g)
        }


        private fun doMyTurns(): List<Game> {
            return allSpells.filter { it.price < player.third && effects.none { eff -> eff.first == it.name } }.map {
                var (p, b) = it.immediate(player, boss)
                Game(manaUsed + it.price, !myTurn, Triple(p.first, 0, p.third - it.price), b, effects + (it.name to it.effect), turns + it.name)
            }
        }

        private fun doBossTurn(): List<Game> {
            return listOf(Game(manaUsed, !myTurn, Triple(player.first - boss.second + player.second, 0, player.third), boss, effects, turns))
        }

        private fun applyEffects(): Game {
            var (p, b) = player to boss
            val effects = effects.map {
                val s = it.second.spell(p, b)
                p = s.first
                b = s.second
                it.first to Effect(it.second.duration - 1, it.second.spell)
            }.filter { it.second.duration > 0 }
            return Game(manaUsed, myTurn, p, b, effects, turns)
        }

        fun isOver() = isWon() || isLost()
        fun isLost(): Boolean = player.first <= 0
        fun isWon(): Boolean = player.first > 0 && boss.first <= 0
    }

    private val noTransf: Transf = { a, b -> a to b }
    private val noEffect = Effect(0, noTransf)

    private val allSpells: List<Spell> = listOf(
            Spell("magic missle", 53, { p, b -> p to (b.first - 4 to b.second) }, noEffect),
            Spell("drain", 73, { p, b -> Triple(p.first + 2, p.second, p.third) to (b.first - 2 to b.second) }, noEffect),
            Spell("shield", 113, noTransf, Effect(6, { p, b -> Triple(p.first, p.second + 7, p.third) to b })),
            Spell("poison", 173, noTransf, Effect(6, { p, b -> p to (b.first - 3 to b.second) })),
            Spell("recharge", 229, noTransf, Effect(5, { p, b -> Triple(p.first, p.second, p.third + 101) to b }))
    )


    data class Spell(val name: String, val price: Int, val immediate: Transf, val effect: Effect)

    data class Effect(val duration: Int, val spell: Transf)


}
typealias Transf = (Triple<Int, Int, Int>, Pair<Int, Int>) -> Pair<Triple<Int, Int, Int>, Pair<Int, Int>>
