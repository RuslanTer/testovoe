import java.io.File
import java.nio.file.Paths;

class code{
    var mass = 1
}

var ascii_table: MutableMap<Int, Char> = mutableMapOf()
fun main() {
//    val asciiMapFile = File("C:\\Users\\akofi\\IdeaProjects\\testovoe\\src\\ascii.txt").readLines()
//    for (n in asciiMapFile) {
//        ascii_table.put(n.split("\t")[0].toInt(), n.split("\t")[1].toCharArray()[0])
//    }
//    println(ascii_table)
    val data =  File("C:\\Users\\akofi\\IdeaProjects\\testovoe\\src\\code.txt").readLines()
    var buff: MutableList<MutableList<Int>> = mutableListOf()
    var buff2: MutableList<Int> = mutableListOf()
    for (n in data) {
        for (symbol in n.split(" ")){
            buff2.add(symbol.toInt())
        }
        if (buff2.size>2){
            buff.add(buff2)
            buff2 = mutableListOf()
        }
    }

//    var symbolsList: MutableList<MutableList<Char>> = mutableListOf()
//    var symbolsListBuff: MutableList<Char> = mutableListOf()
//    for (nums in buff){
//
//        for (num in nums.sorted()){
//            if (num!=null){
//                    ascii_table[num+nums[0]]?.let { symbolsListBuff.add(it) }
//            }
//
//        }
//        symbolsList.add(symbolsListBuff)
//        symbolsListBuff = mutableListOf()
//
//    }
//    for (symbols in symbolsList){
//        println(symbols)
//    }


    for (list in buff) {


//        println(list)
        var rot = list.removeAt(0)
        println(list.sorted()[rot].toChar())
//        for (el in list){
//            print((rot+el).toChar())
//        }
//        println()
        //println(list.sorted())

//       for (sym in binary_search(list.sorted().toMutableList(), 9)){
//           println(ascii_table[sym+rot])
//       }
        //var count = list.count { it==216}
        //print((count+rot).toChar())
//        println((count).toChar())
    }
}

fun reload_search(list: MutableList<Int>, index: Int) {



    }

fun  binary_search(list: MutableList<Int>, index: Int): MutableList<Int>{
    //print(list)
//    print(index)
//    println()
    if (list.size<=2)
        return list
    if (list[index]<216){
        return binary_search(list.slice(index+1..list.size-1).toMutableList(),(list.slice(index+1..list.size-1).size-1)/2 )
    }else{
        return binary_search(list.slice(0..index-1).toMutableList(),list.slice(0..index-1).size/2 )
    }


}