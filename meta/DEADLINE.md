# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice-looking HTML.

## Part 1.1: App Description

> Please provide a friendly description of your app, including
> the primary functions available to users of the app. Be sure to
> describe exactly what APIs you are using and how they are connected
> in a meaningful way.

> **Also, include the GitHub `https` URL to your repository.**

TODO WRITE / REPLACE

    My app uses the users input, which should be some address or location, and gets coordinates. My first api, which is Geocode.xyz API, gets the location from the user input and returns coordinates in longitude and lattitude format.
    My second API, which is the OpenWeather API, gets the coordinates from the first api adn figures out the tempreture at that location. Simply input any address or location, and we'll give you the current temperature there.
    We use Geocode.xyz API to get coordinates from your input, and then OpenWeather API to fetch the temperature at that spot.

## Part 1.2: APIs

> For each RESTful JSON API that your app uses (at least two are required),
> include an example URL for a typical request made by your app. If you
> need to include add
    |itional notes (e.g., regarding API keys or rate
> limits), then you can do that below the URL/URI. Placeholders for this
> information are provided below. If your app uses more than two RESTful
> JSON APIs, then include them with similar formatting.

### API 1

```


https://geocode.xyz/Epps%20Bridge%20Pkwy,%20Athens,%20GA%2030606?json=1&auth=471054895539232410159x63992

```

> Replace this line with notes (if needed) or remove it (if not needed).

### API 2

```
http://api.openweathermap.org/data/3.0/onecall?lat=30.489772&lon=-99.771335&units=imperial&appid=431be9d4368fb6f3c34ed852832d22db
```

> Replace this line with notes (if needed) or remove it (if not needed).

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

I found it intresting that there was an API that could use the coordinates and figure out the weather at the location.


## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

I would like to add some cooler features such as the time of the sunrise and sunset and a couple more features. I would like my app to get more the just the tempreture. I want it to reseamble a real app.
