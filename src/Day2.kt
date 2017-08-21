object Day2 {

    fun countWrappingSizes( list : Iterable<String>): Int {
        return list.sumBy { countWrappingSize(it.split("x")) }
    }

    fun countRibbonSizes( list : Iterable<String>): Int {
        return list.sumBy { countRibbonSize(it.split("x")) }
    }

    private fun countRibbonSize(split: List<String>): Int {
        val (a,b,c)  = split.map { it.toInt() }
        val sizes= listOf(a,b,c)
        return  a*b*c + sizes.sorted().dropLast(1).sum() * 2 }

    private fun countWrappingSize(split: List<String>): Int {
        val (a,b,c)  = split.map { it.toInt() }
        val sizes= listOf(a*b, a*c, b*c)
        return 2*sizes.sum() + sizes.min()!!
    }
}