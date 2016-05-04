import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

            //country constructor

            Country country = new Country(abbr.get(0), names.get(1));
            countries.add(country);

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
        }

        //System.out.println(hashmap);

        //Scanner stuff

        Scanner input = new Scanner(System.in);
        char inputLetter;

        System.out.println("Please enter a letter.");

        String answer = input.nextLine();


        //gets user input

        Character answerChar = answer.charAt(0);

        //needs to check if input is letter
        if (answer.length() != 1) {
            System.out.println("Enter a single letter please!");
            throw new InputMismatchException();
        } else {
            inputLetter = answer.charAt(0);
        }

        //System.out.println(inputLetter);
        //System.out.println(String.valueOf(hashmap.get(inputLetter)));

        //writing to text file


        File f = new File(inputLetter + "_countries.txt");
        FileWriter fileWriter = new FileWriter(f);
        fileWriter.write(String.valueOf(hashmap.get(inputLetter)));
        fileWriter.close();


    }

}
