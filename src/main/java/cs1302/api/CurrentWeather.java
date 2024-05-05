/**
package cs1302.api;

public class Temp {

    private String pericpitation;
    private String humidity;
    private String sunset;
    private String sunrise;

    public Temp(String pericpitation, String humidity, String sunset, String sunrise) {
        this.pericpitation = pericpitation;
        this.humidity = humidity;
        this.sunset = sunset;
        this.sunrise = sunrise;
    }

    public String getPericpitation() {
        return pericpitation;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getSunset() {
        return sunset;
    }

    public String getSunrise() {
        return sunrise;
    }



}
*/

package cs1302.api;

/**
 * currentWeather.
 */

public class CurrentWeather {
    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feelslike;
    private int pressure;
    private int humidity;
    private double dewpoint;
    private double uvi;
    private int clouds;
    private int visibility;
    private double windspeed;
    private int winddeg;
    private double windgust;

    /**
     * uses temp.
     * @param temp
     */

    public CurrentWeather(Double temp) {
        this.temp = temp;
    }

    /**
     * gets tempreture.
     * @return temp
     */

    public Double getTempr() {
        return temp;
    }

}
