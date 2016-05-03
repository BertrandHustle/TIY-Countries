import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

        //holds countries by first letter, arraylist of countries
        HashMap<Character, ArrayList<Country>> hashmap = new HashMap<Character, ArrayList<Country>>();

        File file = new File("countries.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            char hashChar = item.charAt(3);

            String[] abbr = item.split("(\\|).+");
            System.out.println(Arrays.toString(abbr));

        }

        //construct country

    }

}
