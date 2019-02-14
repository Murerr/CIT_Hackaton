import java.io.File
import java.io.FileNotFoundException

fun main(args : Array<String>){

    val fileName = if(args.size == 1) args[0] else "input_1.txt"

    lateinit var lineList : Set<String>

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
        print(getListThirdMostLikedMovie(lineList))
    } else {
        print("ERROR")
    }
}

fun isListSmallerThanThreeLines(lineList: Set<String>): Boolean {
    return lineList.size < 3
}

fun getListThirdMostLikedMovie(lineList: Set<String>): String {
    val list =lineList.toList()

    return list[lineList.size-3]
}


fun readFileToArray(fileName : String) : Set<String> = File(fileName).readLines().toSortedSet()