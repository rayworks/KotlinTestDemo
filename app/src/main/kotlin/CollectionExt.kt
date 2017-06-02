/**
 * Created by Sean on 6/2/17.
 */
fun <T : Comparable<T>> Iterable<T>.sortedDesc(): List<T> {
    var lst: MutableList<T> = this.toMutableList()

    for (i in 0 until lst.size) {
        var curr = lst[i]
        var temp: T = curr
        var index = i;

        for (j in i + 1 until lst.size) {
            if (lst[j] > temp) {
                temp = lst[j]
                index = j
            }
        }

        if (temp != curr) {
            var t = lst[index]
            lst[index] = lst[i]
            lst[i] = t
        }
    }

    return lst
}

fun getList(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDesc()
}