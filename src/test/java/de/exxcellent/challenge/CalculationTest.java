package de.exxcellent.challenge;

import de.exxcellent.challenge.data.FootballData;
import de.exxcellent.challenge.data.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {


    @Test
    void getIdentifierWithSmallestSpread_ValidWeatherData() {
        // given
        List<WeatherData> weatherDataList = Arrays.asList(
                new WeatherData(1, 20, 10),
                new WeatherData(2, 15, 12),
                new WeatherData(3, 18, 14));

        // when
        String result = Calculation.getIdentifierWithSmallestSpread(weatherDataList);

        // then
        assertEquals(String.valueOf(2), result, "Day 2 should be the day with smallest temperature spread.");

    }

    @Test void getIdentifierWithSmallestSpread_EmptyWeatherData() {
        // given
        List<WeatherData> weatherDataList = new ArrayList<>();

        // when
        String result = Calculation.getIdentifierWithSmallestSpread(weatherDataList);

        // then
        assertEquals(null, result, "There should be no day as a result!");

    }

    @Test
    void getIdentifierWithSmallestSpread_ValidFootballData() {
        // given
        List<FootballData> footballDataList = Arrays.asList(
                new FootballData("Arsenal", 79, 36),
                new FootballData("Liverpool", 67, 30),
                new FootballData("Newcastle", 74, 52));

        // when
        String result = Calculation.getIdentifierWithSmallestSpread(footballDataList);

        // then
        assertEquals("Newcastle", result, "Newcastle should have the minimal goal spread.");

    }

    @Test void getIdentifierWithSmallestSpread_EmptyFootballData() {
        // given
        List<FootballData> footballDataList = new ArrayList<>();

        // when
        String result = Calculation.getIdentifierWithSmallestSpread(footballDataList);

        // then
        assertEquals(null, result, "There should be no day as a result!");
    }
}

