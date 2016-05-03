/**
 * Constructs countries
 */

public class Country {

    String name;
    String abbreviation;

    public Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString(){

        return this.name + " " + this.abbreviation;

    }
}
