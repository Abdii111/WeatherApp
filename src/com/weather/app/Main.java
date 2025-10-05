package com.weather.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherFetcher fetcher = new WeatherFetcher();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Väderkoll CLI ---");
        System.out.print("Ange stadsnamn: ");
        String city = scanner.nextLine();

        if (city.trim().isEmpty()) {
            System.out.println("Inget stadsnamn angivet. Avslutar.");
            return;
        }

        try {
            WeatherResponse weather = fetcher.fetchWeather(city);

            System.out.println("\n=================================");
            System.out.printf("Väder för: %s\n", weather.name);
            System.out.println("---------------------------------");

            System.out.printf("Förhållanden: %s\n", weather.weather[0].description);
            System.out.printf("Temperatur: %.1f °C (känns som %.1f °C)\n",
                    weather.main.temp, weather.main.feels_like);
            System.out.printf("Luftfuktighet: %d%%\n", weather.main.humidity);
            System.out.println("=================================");

        } catch (Exception e) {
            System.err.println("Fel vid hämtning: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}