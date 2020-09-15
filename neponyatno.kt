import java.io.File
import java.nio.file.Paths;
import kotlin.math.abs
import kotlin.math.ceil

var alphabet: String = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"

fun main() {
    val path = System.getProperty("user.dir")
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
    println(bubbleSort(mutableListOf(2,1,3,4,5,6)))
    var cipher = "тъясвямы баъгь иъгэс бедн ь адуцде"
    println(сaesarEncryption(cipher, 213, alphabet))
    for (code in arrayCodes){
        var aloneNumber = code.removeAt(0)
        var sortedCode: MutableList<Int> = bubbleSort(code)
        var searchValue = sortedCode[aloneNumber]
        print(sortedCode[binarySearch(sortedCode, searchValue, 0, sortedCode.size-1)].toChar())
    }

}

//for lower case only
fun сaesarEncryption(text: String, rot: Int, alpha: String):String {
    val n = alpha.length
    var result: String = ""
    for (symbol in text){
        if (symbol==' '){ //for space
            result += ' '
            continue
        }
        var y = alpha.indexOf(symbol)
        var x = kotlin.math.abs(y + rot) % n
        result += alpha[x]
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
        for (i in 0..array.size-2-step){
            if (array[i]>array[i+1]){
                isSorted=false
                array.swap(i, i+1)
            }
        }
    }
    return array
}

fun binarySearch(array: MutableList<Int>, value: Int, l: Int, r: Int): Int{
    if (r >= l){
        val m: Int = l + (r - l ) / 2
        if (array[m] == value)
            return m
        if (array[m] < value){
            return binarySearch(array, value, m + 1, r)
        }
        else {
            return binarySearch(array, value, l,m - 1)
        }
    }
    return -1
}



