object Day3 {

    fun makeMoves(route: String) : Int {
        val positions = mutableSetOf<Pair<Int, Int>>()
        val moves = mapOf('>' to Pair(1,0),'<' to Pair(-1, 0),'^' to Pair(0, -1), 'v' to Pair(0, 1))
        var currentPosition = 0 to 0
        positions.add(currentPosition)
        route.forEach {
            val move = moves[it]!!
            currentPosition = currentPosition.first + move.first to currentPosition.second + move.second
            positions.add(currentPosition)
        }
        return positions.size
    }

    fun makeMoves2(route: String): Int {
        val positions = mutableSetOf<Pair<Int, Int>>()
        val moves = mapOf('>' to Pair(1,0),'<' to Pair(-1, 0),'^' to Pair(0, -1), 'v' to Pair(0, 1))
        var currentPosition1 = 0 to 0
        var currentPosition2 = 0 to 0
        positions.add(currentPosition1)
        positions.add(currentPosition2)
        route.forEachIndexed { i, it ->
            val move = moves[it]!!
            val newPosition = (if(i % 2 == 0) currentPosition1 else currentPosition2).let{
                it.first + move.first to it.second + move.second
            }
            if (i %2 == 0){
                currentPosition1 = newPosition
            } else {
                currentPosition2 = newPosition
            }
            positions.add(currentPosition1)
            positions.add(currentPosition2)
        }
        return positions.size
    }


}