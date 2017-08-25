object Day10 {

    fun sayAndLookTimes(times: Int, s : String): String{
        if (times == 0){
            return s
        } else {
            return sayAndLookTimes(times-1, sayAndLook(s))
        }
    }

    fun sayAndLook(s : String): String{
        var i = 0
        val sb = StringBuilder()
        while (i < s.length){
            val c = s[i]
            var n = 1
            while (++i < s.length){
                if (s[i] == c) n++ else break
            }
            sb.append(n).append(c)
        }
        return sb.toString()
    }
}