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

    var planets = getPlanetsNumber(lineList)
    lineList = lineList.drop(1);
    var daysList = getDaysList(lineList,planets)
    var holidayList = getHolidayList(lineList,planets)
    print("TEST")
}

fun getHolidayList(lineList: List<String>, planets: Int): List<String> {
    return lineList.drop(planets)
}

fun getDaysList(lineList: List<String>, planets: Int): List<String> {
    return lineList.dropLast(planets)
}

fun getPlanetsNumber(lineList: List<String>): Int{
    return lineList[0].toInt()
}

fun getOutput(sentence:String,planets:Int): String {
    return "test"
}

fun readFileToArray(fileName : String) : List<String> = File(fileName).readLines()