import java.io.File
import java.io.FileNotFoundException

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

    val sentence = lineList[0]
    print(getOutput(sentence))
}

fun getOutput(sentence:String): String {
    var list = listOf<Any>()
    sentence.toUpperCase().forEach {
        if (it.isLetter() && !list.contains(it)){
            list+=it
        }
    }
    return list.size.toString()
}

fun readFileToArray(fileName : String) : List<String> = File(fileName).readLines()