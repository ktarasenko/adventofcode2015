object Day4 {


    fun findLowest(code : String, seq : String): Int {
        var currentInt = 0
        while (true) {
            currentInt++
            val md5 = (code + currentInt).md5()
            if (md5.startsWith(seq)) {
                return currentInt
            }
        }
    }
}