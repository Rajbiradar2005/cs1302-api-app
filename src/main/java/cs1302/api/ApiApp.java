package cs1302.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;
import java.net.http.HttpClient;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.layout.TilePane;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.lang.Thread;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.time.LocalTime;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import cs1302.api.ApiThing;
import cs1302.api.ApiResult;
import cs1302.api.StandardAddress;
import cs1302.api.WeatherData;
import cs1302.api.CurrentWeather;


/**
 * REPLACE WITH NON-SHOUTING DESCRIPTION OF YOUR APP.
 */
public class ApiApp extends Application {
    Stage stage;
    Scene scene;
    VBox root;

    private TextField urlField;
    private Button search;
    private String finalURI;
    private HBox base;
    private Label enterLabel;
    private String lastURI;
    private Label weatherLabel;
    private Label cordLabel;
    private Label formatLabel;

    private static final String LOCATION_API = "https://geocode.xyz/";
    private static final String WEATHER_API = "https://api.openweathermap.org/data/3.0/onecall?";

    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    /**
     * converts the corrdinates, using the second api, to the tempreture at the location.
     * @param apiThing which gets the data and inserts it in
     */


    public void convertCord(ApiThing apiThing) {
        try {
            String lat = "lat=" + apiThing.getLatt();
            String longt = "&lon=" + apiThing.getLongt()
                + "&units=imperial&appid=431be9d4368fb6f3c34ed852832d22db";
            this.lastURI = WEATHER_API + lat + longt;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(lastURI))
                .build();

            HttpResponse<String> response = HTTP_CLIENT
                .send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new IOException(response.toString());
            }
            String jsonString = response.body();
            //System.out.println("********** RAW JSON STRING: **********");
            //System.out.println(jsonString.trim());

            //what is this

            WeatherData weatherData = GSON
                .fromJson(jsonString, WeatherData.class);

            // printCord(weatherData);

            if (apiThing.getLatt().equals("0.00000") && apiThing.getLongt().equals("0.00000")) {
                weatherLabel.setText("This address does not exit. Please check for typos.");
                cordLabel.setText("Latitude and Longitude does not exit.");
            } else {
                weatherLabel.setText("The temperature is: " +  weatherData.getCurrent().getTempr());
            }


        } catch (IOException | InterruptedException e) {
            //System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * converts the address given by the useer into corrdinates.
     */

    public void convertAddress() {
        try {
            String address = URLEncoder.encode(urlField.getText(), StandardCharsets.UTF_8);
            String query = "?json=1&auth=471054895539232410159x63992";
            this.finalURI = LOCATION_API + address + query;

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(finalURI))
                .build();

            HttpResponse<String> response = HTTP_CLIENT
                .send(request, BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new IOException(response.toString());
            }

            String jsonString = response.body();
            //System.out.println("********** RAW JSON STRING: **********");
            //System.out.println(jsonString.trim());




            ApiThing apiThing = GSON
                .fromJson(jsonString, ApiThing.class);

            //ApiApp.printApiThing(apiThing);

            convertCord(apiThing);

            if (apiThing.getLatt().equals("0.00000") && apiThing.getLongt().equals("0.00000")) {
                throw new IOException("The address does not exist");
            } else {
                cordLabel.setText("Latitude: " + apiThing.getLatt() + " Longitude: " +
                                   apiThing.getLongt());
            }



        } catch (IOException | InterruptedException e) {
            //System.err.println(e);
            //e.printStackTrace();
            alertError(e);

        }
    }

    /**
     * used to throw pop up errors when there is an error.
     * @param cause which is the error that is thrown
     */

    public void alertError(Throwable cause) {

        String ex = "URI: " + LOCATION_API + "\n\n";
        TextArea text = new TextArea(ex + cause.toString());
        text.setEditable(false);
        Alert alert = new Alert(AlertType.ERROR);
        alert.getDialogPane().setContent(text);
        alert.setResizable(true);
        alert.showAndWait();

    }


    /**



    private static void printApiThing(ApiThing apiThing) {
        System.out.println();
        System.out.println("********** PRETTY JSON STRING: **********");
        System.out.println(GSON.toJson(apiThing));
        System.out.println();
        if (apiThing.getStandard() != null) {
            System.out.println("Latitude: " + apiThing.getLatt());
            System.out.println("Longitude: " + apiThing.getLongt());

        } else {
            System.out.println("No results found");
        }
        /**
        if (apiThing.results == null) {
            System.out.println("********** PARSED RESULTS: **********");
        } else {
            System.out.printf("resultCount = %s\n", apiThing.resultCount);
            for (int i = 0; i < apiThing.results.length; i++) {
                System.out.printf("apiThing.results[%d]:\n", i);
                ApiResult result = apiThing.results[i];
                System.out.printf(" - wrapperType = %s\n", result.wrapperType);
                System.out.printf(" - kind = %s\n", result.kind);
                //System.out.printf(" - artworkUrl100 = %s\n", result.artworkUrl100);
            }
        }





    private static void printCord(WeatherData weatherData) {
        System.out.println();
        System.out.println("********** PRETTY JSON STRING: **********");
        System.out.println(GSON.toJson(weatherData));
        System.out.println();
        if (weatherData.getCurrent() != null) {
            System.out.println("Temperature: " + weatherData.getCurrent().getTempr());
            System.out.println("it is working there is data");

        } else {
            System.out.println("No results found");
            System.out.println("Temperature: " + weatherData.getTemp());
        }
    }
    */

    /**
     * needed for clicking buttons.
     * @param target defualt thread
     */

    public static void runNow(Runnable target) {
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.start();
    }
    /**
     * Constructs an {@code ApiApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */

    public ApiApp() {
        this.stage = null;
        this.scene = null;


        this.root = new VBox();
        this.urlField = new TextField("Street(optional), City, State, Zip Code");
        this.search = new Button("Search");
        this.base = new HBox();
        this.enterLabel = new Label("Enter Address:");
        this.weatherLabel = new Label("The tempreture is: ");
        this.cordLabel = new Label("Lat:  Long:");
        this.formatLabel = new Label("Here is the format: Street(optional), City, State, Zip Code");
        HBox.setHgrow(this.urlField, Priority.ALWAYS);

        base.getChildren().addAll(enterLabel, urlField, search);


    } // ApiApp

/**
    public void init() {
        System.out.println("init() called");
        urlSection = new HBox();
        urlSection.getChildren().addAll(urlField, search);
    }
*/

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        this.stage = stage;

        // demonstrate how to load local asset using "file:resources/"
        Image bannerImage = new Image("file:resources/");
        ImageView banner = new ImageView(bannerImage);
        banner.setPreserveRatio(true);
        banner.setFitWidth(640);

        // some labels to display information
        Label notice = new Label("Weather App!!!");

        // setup scene
        root.getChildren().addAll(banner, formatLabel, base,cordLabel, weatherLabel);
        scene = new Scene(root);

        // setup stage
        stage.setTitle("ApiApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

        this.runNow( () -> {
            this.search.setOnAction(t -> {
                this.convertAddress();
            });
        });

    } // start
} // ApiApp
