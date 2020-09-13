import java.io.File
import java.nio.file.Paths;
import kotlin.math.ceil


fun main() {
    val path = System.getProperty("user.dir")
    println("$path\\code.txt")
    val data = File("$path\\src\\code.txt").readLines()
    var arrayCodes: MutableList<MutableList<Int>> = mutableListOf()
    var lineCodes: MutableList<Int> = mutableListOf()
    for (n in data) {
        for (symbol in n.split(" ")) {
            lineCodes.add(symbol.toInt())
        }
        if (lineCodes.size > 2) {
            arrayCodes.add(lineCodes)
            lineCodes = mutableListOf()
        }
    }
    var cipher = "тъясвямы баъгь иъгэс бедн ь адуцде"
    println(сaesarDecoder(cipher, 15))
    for (code in arrayCodes){
        var aloneNumber = code.removeAt(0)
        var sortedCode: MutableList<Int> = bubbleSort(code)
        var searchValue = sortedCode[aloneNumber]
        print(sortedCode[binarySearch(sortedCode, searchValue)].toChar())
    }

}

//for lower case only
fun сaesarDecoder(text: String, rot: Int):String {
    var result: String = ""
    for (symbol in text){
        if (symbol.toInt()<=1103 && symbol.toInt()+rot%33-1>=1103){ // for go around 1072..1103
            if (1071 - ( 1103 - symbol.toInt() -  rot%33)>1077){ // for char "ё" (1077 = "e")
                result += (1071 - 1 - ( 1103 - symbol.toInt() -  rot%33)).toChar()
            }
            else {
                result += (1071 - ( 1103 - symbol.toInt() -  rot%33)).toChar()
            }
        }
        else{
            if (symbol.toInt()<=1077 && (symbol.toInt()+rot%33)>1077) {// for char "ё" (1077 = "e")
                result += ((symbol.toInt()+rot%33-1)) .toChar()
            }
            else {
                result += (symbol.toInt()+rot%33) .toChar()
            }
        }
    }
    return result
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun bubbleSort(array: MutableList<Int>): MutableList<Int>{
    var isSorted = false
    for (step in 0..array.size-2){
        if (isSorted){return array}
        isSorted = true
        for (i in 0..array.size-2){
            if (array[i]>array[i+1]){
                isSorted=false
                array.swap(i, i+1)
            }
        }
    }
    return array
}

fun binarySearch(array: MutableList<Int>, value: Int): Int{
    var l = 0
    var r = array.size - 1
    while (l <= r){
        val m: Int = (l + r ) / 2
        if (array[m] == value)
            return m
        if (array[m] < value){
            l = m + 1
        }
        else {
            r = m - 1
        }
    }
    return -1
}



