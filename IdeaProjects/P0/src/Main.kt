import java.io.File
import java.io.FileNotFoundException

fun main(args : Array<String>){

    val fileName = if(args.size == 1) args[0] else "input_1.txt"

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


    if(!isListSmallerThanThreeLines(lineList)){
        val sum = sumFirstTreeLine(lineList)
        print(sum.toString())
    } else {
        print("Error")
    }
}

fun isListSmallerThanThreeLines(lineList: List<String>): Boolean {
    return lineList.size < 3;
}

fun sumFirstTreeLine(list: List<String>) : Int {
    var sum=0;
    for(i in 0..2){
        sum += list[i].toInt()
    }

    return sum

}

fun readFileToArray(fileName : String) : List<String> = File(fileName).readLines()