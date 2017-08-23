object Day8 {


    fun countCharacters(s: String): Int {
        var i = 0
        var count = 0
        while (i < s.length){
            i = when (s[i]){
                '"' -> i+1
                '\\' -> when(s[i+1]){
                    'x' -> {count++; i+4}
                    else -> {count++; i+2}
                }
                else -> {count++; i+1}
            }
        }
        return count
    }

    fun countEncodedCharacters(s: String): Int {
        var i = -1
        var count = 2
        while (++i < s.length){
            count = when (s[i]){
                '"','\\'  -> count + 2
                else -> count +1
            }
        }
        return count
    }
}