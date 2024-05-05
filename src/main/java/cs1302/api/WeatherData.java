/**
package cs1302.api;

public class WeatherData {

    private Temp temp;
    private String temperature;

    public String getTempr() {
        return temperature;
    }

    public Temp getTemp() {
        return temp;
    }
}
*/

package cs1302.api;

/**
 * weather data class.
 */

public class WeatherData {
    private double lat;
    private double lon;
    private String timezone;
    private long timezoneoffset;
    private CurrentWeather current;
    private Double temp;

    /**
     * gets lat.
     * @return lat
     */

    public Double getLat() {
        return lat;
    }

    /**
     * gets long.
     * @return long
     */

    public Double getLon() {
        return lon;
    }

    /**
     * gets timezone.
     * @return timezone
     */

    public String getTimezone() {
        return timezone;
    }

    /**
     * gets CurrentWeather.
     * @return Current Weather data
     */

    public CurrentWeather getCurrent() {
        return current;
    }

    /**
     * gets temp.
     * @return temp
     */

    public Double getTemp() {
        return temp;
    }

}
