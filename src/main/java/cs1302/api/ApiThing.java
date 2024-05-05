package cs1302.api;

/**
 * class ApiThing needed for api.
 */

public class ApiThing {
    private StandardAddress standard;
    private String longt;
    private String latt;

    /**
     * gets information from the standerd class.
     * @return getStanderd information
     */

    public StandardAddress getStandard() {
        return standard;
    }

    /**
     * gets longitude of the location.
     * @return longt of the location
     */

    public String getLongt() {
        return longt;
    }

    /**
     * gets the lattitude.
     * @return the latt of the location
     */

    public String getLatt() {
        return latt;
    }


    /**
    // Override toString() for better logging
    @Override
    public String toString() {
        return "ApiThing{" +
                "standard=" + standard +
                ", longt='" + longt + '\'' +
                ", latt='" + latt + '\'' +
                '}';
    }
    */
}
