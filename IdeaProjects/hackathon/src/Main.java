import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileName = args.length == 1 ? args[0] : "input_1.txt";
        System.out.println(fileName);
        ArrayList<String> linesList = null;

        try{
            linesList = readFileToList(fileName);
        }
        catch(IOException e){
            System.out.println(e.getMessage() +
                    "\nTry placing the input file in this directory" +
                    "\n" + System.getProperty("user.dir"));
            System.exit(1);
        }

        linesList.forEach((line) -> System.out.println(line));

    }

    private static ArrayList<String> readFileToList(String fileName) throws IOException {

        File input = new File(fileName);
        FileReader fileReader = new FileReader(input);
        BufferedReader reader = new BufferedReader(fileReader);
        reader.readLine();

        ArrayList<String> linesList = new ArrayList<String>();
        /*
        while(line != null){
            linesList.add(line);
            line = reader.readLine();


        }*/
        reader.close();

        return linesList;
    }

}
