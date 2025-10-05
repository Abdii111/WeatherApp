package com.weather.app;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherFetcher {

    private static final String API_KEY = "56193f25a5438f4e9bd83a2868019ce2";

    private static final String BASE_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=se";

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public WeatherResponse fetchWeather(String city) throws Exception {
        String url = String.format(BASE_URL, city, API_KEY);

        System.out.println("Hämtar data från: " + url);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Kunde inte hämta väderdata. Kontrollera stadsnamn eller API-nyckel. Felkod: "
                    + response.statusCode());
        }

        String jsonResponse = response.body();
        return gson.fromJson(jsonResponse, WeatherResponse.class);
    }
}
