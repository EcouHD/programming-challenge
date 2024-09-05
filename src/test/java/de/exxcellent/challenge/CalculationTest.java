package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {


    @Test
    void getDayWithSmallestTemperatureSpread_ValidData() {
        // given
        List<WeatherData> weatherDataList = Arrays.asList(
                new WeatherData(1, 20, 10),
                new WeatherData(2, 15, 12),
                new WeatherData(3, 18, 14));

        // when
        int result = Calculation.getDayWithSmallestTemperatureSpread(weatherDataList);

        // then
        assertEquals(2, result, "Day 2 should be the day with smallest temperature spread.");

    }

    @Test void getDayWithSmallestTemperatureSpread_EmptyData() {
        // given
        List<WeatherData> weatherDataList = new ArrayList<>();

        // when
        int result = Calculation.getDayWithSmallestTemperatureSpread(weatherDataList);

        // then
        assertEquals(-1, result, "There should be no day as a result!");
    }
}
