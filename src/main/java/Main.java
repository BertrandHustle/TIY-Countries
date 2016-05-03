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

        //init

        ArrayList<String> abbr = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Country> countries = new ArrayList<>();
        ArrayList<Character> hashChar = new ArrayList<>();

        /*scans countries.txt and creates separate arrays for abbrevations and names
        along with first letter in each name*/

        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            hashChar.add(item.charAt(3));

            abbr.add(Arrays.toString(item.split("(\\|).+")));
            names.add(Arrays.toString(item.split(".*(\\|)")));
            //trim here?

        }

        System.out.println(abbr);
        System.out.println(names);

        //abbr.add(abbrArray);
        //names.add(namesArray);

        //construct countries

        for (int i = 0; i < names.size(); ++i){



            Country country = new Country(names.get(i), abbr.get(i));
            countries.add(country);

        }

        for(Country country : countries){
            System.out.println(country.getAbbreviation() + country.getName());
        }

    }

}
