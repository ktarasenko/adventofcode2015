object Day5 {


    val vovels = setOf('a','e', 'i','o','u')
    val prohibited = setOf("ab", "cd", "pq", "xy")

    fun isNice(st : String): Boolean{
        var v = 0
        var hadDoubles = false
        for (i in 0 until st.length -1) {
            val pair = st.substring(i, i+2)
            if (prohibited.contains(pair)){
                return false
            }
            if (st[i] == st[i+1]){
                hadDoubles = true
            }
            if (vovels.contains(st[i])){
                v++
            }
        }
        if (vovels.contains(st.last())){
            v++
        }
        return v > 2 && hadDoubles
    }

    fun isNice2(st : String): Boolean{
        var hadDoubles = false
        var hasT = false
        for (i in 0 until st.length -2) {
            val pair = st.substring(i..i+1)
            if (st.substring(i+2).contains(pair)){
                hadDoubles = true
            }
            if (st[i] == st[i+2]){
                hasT = true
            }
        }
        return hadDoubles && hasT
    }
}