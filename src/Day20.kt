object Day20 {

    private fun dividersSum(n : Int): Int = (1..Math.sqrt(n.toDouble()).toInt())
                .filter { n % it == 0 }
                .sumBy { it + if (n/ it == it) 0 else n/it }



    fun solve1(n: (Int) -> Boolean): Int {
        var i = 0
        while (true){
            val v = dividersSum(++i) * 10
            if (n(v)){
                return i
            }
        }
    }


    private fun dividersSum2(n : Int): Int = (n.downTo(Math.max(1, n/50+1)))
                .filter { n % it == 0 }
                .sumBy {
                    val q = n/it
                    if (q <= 50){
                        it
                    } else {
                        0
                    }
                }



    fun solve2(n: (Int) -> Boolean): Int {
        var i = 100000-1
        while (true){
            val v = dividersSum2(++i) * 11
            if (i % 10000 == 0) println(i)
            if (n(v)){
                return i
            }
        }
    }

}