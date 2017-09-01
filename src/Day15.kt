object Day15 {

    data class Ingridient(val capacity: Int, val durability: Int, val flavor : Int, val texture: Int, val calories: Int)

    fun findBestCookie(ing: List<String>): Long =
        allCookies(ing).map{ with(it){0L + Math.max(0,capacity) * Math.max(0, durability) * Math.max(0,flavor) * Math.max(0, texture)}}.max()!!


    fun findBestCookieCalories(ing: List<String>): Long =
        allCookies(ing).filter { it.calories == 500 }.map{ with(it){0L + Math.max(0,capacity) * Math.max(0, durability) * Math.max(0,flavor) * Math.max(0, texture)}}.max()!!


    private fun allCookies(ing: List<String>): List<Ingridient> {
        val ingridients = ing.map {
            val s = it.replace(",", "").split(" ")
            Ingridient(s[2].toInt(), s[4].toInt(), s[6].toInt(), s[8].toInt(), s[10].toInt())
        }

        return combineCookies(100, ingridients).map{ it.fold(Ingridient(0, 0,0 ,0 ,0)){s, it ->
            Ingridient(s.capacity + it.first.capacity * it.second, s.durability + it.first.durability * it.second,s.flavor + it.first.flavor * it.second,
                    s.texture + it.first.texture * it.second,s.calories + it.first.calories * it.second)
        }}
    }

    private fun combineCookies(size: Int, ingridients: List<Ingridient>): List<List<Pair<Ingridient, Int>>>{
        val f = ingridients.first()
        if (ingridients.size == 1){
            return listOf(listOf(f to size))
        } else {
            return (0..size).flatMap { i ->
                combineCookies(size - i, ingridients.drop(1)).map { listOf(f to i) + it }
            }
        }
    }
}