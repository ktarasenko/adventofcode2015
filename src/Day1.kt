object Day1 {

    fun countFloor(list: String) : Int{
        return list.fold(0, {acc, it -> acc + when(it){
            '(' -> 1
            else -> -1
        }})
    }

    fun firstBasement(list: String) : Int{
        var acc = 0
        return list.takeWhile {
            acc += +when (it) {
                '(' -> 1
                else -> -1
            }
            acc >= 0
        }.length + 1
    }
}