package de.exxcellent.challenge;

import de.exxcellent.challenge.data.FootballData;
import de.exxcellent.challenge.data.WeatherData;

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

        List<WeatherData> weatherDataList = Reader.readFromCSV("src/main/resources/de/exxcellent/challenge/weather.csv", data -> {
            int day = Integer.parseInt(data[0]);
            int maxTemp = Integer.parseInt(data[1]);
            int minTemp = Integer.parseInt(data[2]);
            return new WeatherData(day, maxTemp, minTemp);
        });

        String dayWithSmallestTempSpread = Calculation.getIdentifierWithSmallestSpread(weatherDataList);;     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        List<FootballData> footballDataList = Reader.readFromCSV("src/main/resources/de/exxcellent/challenge/football.csv", data -> {
            String name = data[0];
            int goals = Integer.parseInt(data[5]);
            int goalsAllowed = Integer.parseInt(data[6]);
            return new FootballData(name, goals, goalsAllowed);
        });

        String teamWithSmallestGoalSpread = Calculation.getIdentifierWithSmallestSpread(footballDataList);; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

    }
}
