import java.io.File
import java.io.FileNotFoundException

fun main(args : Array<String>){

    var fileName = if(args.size == 1) args[0] else "input.txt"

    lateinit var lineList : List<String>

    try{ lineList = readFileToArray(fileName) }
    catch(e : FileNotFoundException){
        println(e.message +
                "\nTry placing the input file in the following directory: "
                        + System.getProperty("user.dir"))
        System.exit(0)
    }

    print(lineList)
}

fun readFileToArray(fileName : String) : List<String> = File(fileName).readLines()