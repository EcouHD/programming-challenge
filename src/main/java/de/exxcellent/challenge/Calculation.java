package de.exxcellent.challenge;

import java.util.List;

public class Calculation {
    public static int getDayWithSmallestTemperatureSpread(List<WeatherData> weatherDataList) {
        int minSpreadDay = -1;
        int minSpread = Integer.MAX_VALUE;

        for(WeatherData data: weatherDataList) {
            if (data.getTempSpread() < minSpread) {
                minSpread = data.getTempSpread();
                minSpreadDay = data.getDay();
            }
        }
        return minSpreadDay;
    }
}
