package cs1302.api;

/**
 * Standerd Address class that gets information abt the location.
 */

public class StandardAddress {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;

    /**
     * Standerd Address stuff.
     * @param street
     * @param city
     * @param state
     * @param country
     * @param zip
     */

    public StandardAddress(String street, String city, String state, String country, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    /**
     * gets street.
     * @return street
     */

    public String getStreet() {
        return street;
    }

    /**
     * gets city.
     * @return city
     */

    public String getCity() {
        return city;
    }

    /**
     * gets the State.
     * @return state
     */

    public String getState() {
        return state;
    }

    /**
     * gets the country.
     * @return country
     */

    public String getCountry() {
        return country;
    }

    /**
     * gets the zip code.
     * @return zip code
     */

    public String getZip() {
        return zip;
    }

}
