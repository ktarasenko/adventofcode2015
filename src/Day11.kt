object Day11 {

    fun isValid(s: String): Boolean {
        var incr = false
        val banned = setOf('i', 'o', 'l')
        val pairs = mutableSetOf<String>()
        for (i in 0 until s.length -2) {
            if (banned.contains(s[i])){
                return false
            }
            if (!incr && (s[i+2] - s[i+1] == 1 && s[i+1] - s[i] == 1)){
                incr = true
            }
            if (s[i] == s[i+1]){
                pairs.add(s.substring(i..i+1))
            }
        }

        if (s.last() == s[s.length - 2]) {
            pairs.add(s.substring(s.length -2))
        }

        return incr && pairs.size > 1
    }

    fun nextValidPassword(s: String): String {
        var p = s
        do {
            p = nextPassword(p.toCharArray())
        } while (!isValid(p))
        return p
    }

    val zp =  'z'.toInt() + 1

    private fun nextPassword(s: CharArray): String {
        var res = 1
        var i = s.size
        while (--i >= 0 && res > 0){
            val c = s[i].toInt() + res
            res = c / zp
            s[i] = if (res == 1) 'a' else (c % zp).toChar()

        }
        return s.joinToString("")
    }
}