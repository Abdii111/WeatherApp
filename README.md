🌦 Väderkollen (WeatherApp CLI)
Detta är ett enkelt program som körs i terminalen och som hämtar aktuell väderdata för valfri stad.

Detta projekt visar min förmåga att arbeta med moderna Java-tekniker:

API-Integration: Appen pratar med en extern tjänst (OpenWeatherMap) över internet för att hämta riktig data.

JSON-hantering: Jag använder biblioteket Gson för att läsa och omvandla den komplicerade JSON-datan från API:et till enkla Java-objekt.

Nätverkskommunikation: Använder Javas inbyggda HttpClient för att skicka förfrågningar över nätverket.

Hur Du Använder Appen
Sätt in API-nyckeln: Öppna filen WeatherFetcher.java och klistra in din personliga OpenWeatherMap-nyckel.

Kör Main.java: Programmet startar och ber dig skriva in en stad.

Resultat: Appen skriver ut temperatur, känsla och väderförhållanden direkt i terminalen.

Exempel
--- Väderkoll CLI ---
Ange stadsnamn: Stockholm

=================================
Väder för: Stockholm
---------------------------------
Förhållanden: lätt regn
Temperatur: 12.3 °C (känns som 10.5 °C)
Luftfuktighet: 87%
=================================
