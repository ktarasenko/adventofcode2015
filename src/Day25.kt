object Day25 {

    fun code(prevCode : Long): Long = prevCode * 252533 % 33554393
    fun codeN(n: Int): Long {
        var code = 20151125L
        repeat(n-1, {code = code(code)})
        return code
    }

    fun getDayN(r: Int, c: Int): Int {
        val prevRowN = r + c - 2
        var prevRowLast = (prevRowN + 1) * prevRowN / 2
        return prevRowLast + c
    }
}