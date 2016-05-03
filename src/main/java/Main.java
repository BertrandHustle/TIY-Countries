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

        ArrayList<Country> countries = new ArrayList<>();

        /*scans countries.txt and creates separate arrays for abbrevations and names
        along with first letter in each name*/

        while (scanner.hasNext()) {
            String item = scanner.nextLine();

            ArrayList<String> abbr = new ArrayList<>(Arrays.asList(item.split("(\\|).+")));
            ArrayList<String> names = new ArrayList<>(Arrays.asList(item.split("[A-Z]..")));

            System.out.println(abbr);
            System.out.println(names);

            //country constructor

            Country country = new Country(abbr.get(0), names.get(1));
            countries.add(country);

            System.out.println(names.get(1));

        }

        //construct arrays by letter


        //add country arrays/letters to hashmap

        for(Country country : countries){

            //first letter of the country
            char letter = country.getName().charAt(0);

            //loops over country list and adds countries by letter
            ArrayList<Country> c = new ArrayList<>();
            for(Country alphaCountries: countries){

                if (alphaCountries.getName().charAt(0) == letter){
                    c.add(alphaCountries);
                }

            }

            hashmap.put(country.getName().charAt(0), c);

            System.out.println(hashmap);
        }

    }

}
