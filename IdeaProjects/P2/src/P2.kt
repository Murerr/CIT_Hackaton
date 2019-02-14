import java.io.File
import java.io.FileNotFoundException
import kotlin.math.abs

fun main(args : Array<String>){

    val fileName = if(args.size == 1) args[0] else "input_5.txt"

    lateinit var lineList : List<String>

    try{
        lineList = readFileToArray(fileName)
    }
    catch(e : FileNotFoundException){
        println(e.message +
                "\nTry placing the input file in the following directory: "
                + System.getProperty("user.dir"))
        System.exit(0)
    }
    val voucher:Int = getVoucherValue(lineList)
    lineList = lineList.drop(1)
    print(getProductToBuy(lineList,voucher))

}

fun getVoucherValue(lineList: List<String>): Int {
    return lineList.first().toInt()
}


fun getProductToBuy(lineList: List<String>,voucher:Int): String {
    var list = listOf<Int>()
    lineList.forEachIndexed { index, _ ->
            lineList.drop(index+1).forEachIndexed { _, p2 ->
                val sum = voucher -(lineList[index].toInt() + p2.toInt())
                list += abs(sum)
            }
    }
    return list.min().toString()

}

fun readFileToArray(fileName : String) : List<String> = File(fileName).readLines()