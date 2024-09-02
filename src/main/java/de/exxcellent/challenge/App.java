package de.exxcellent.challenge;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        List<WeatherData> weatherDataList = Reader.readFromCSV("src/main/resources/de/exxcellent/challenge/weather.csv", data -> {
            int day = Integer.parseInt(data[0]);
            int maxTemp = Integer.parseInt(data[1]);
            int minTemp = Integer.parseInt(data[2]);
            return new WeatherData(day, maxTemp, minTemp);
        });

        int minSpreadDay = Calculation.getDayWithSmallestTemperatureSpread(weatherDataList);

        System.out.printf("Day with smallest temperature spread : %d%n", minSpreadDay);
    }
}
