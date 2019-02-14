import java.io.*;
import java.util.ArrayList;

public class CommandLineExample {
    public static void main(String[] args){

        String fileName = args.length == 1 ? args[0] : "input.txt";

        ArrayList<String> linesList = null;

        try{ linesList = readFileToList(fileName); }
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
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();

        ArrayList<String> linesList = new ArrayList<String>();

        while(line != null){
            linesList.add(line);
            line = reader.readLine();

        }

        return linesList;
    }
}
