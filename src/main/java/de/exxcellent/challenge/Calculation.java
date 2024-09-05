package de.exxcellent.challenge;

import java.util.List;

public class Calculation {
    public static int getDayWithSmallestTemperatureSpread(List<WeatherData> weatherDataList) {
        int minSpreadDay = -1;
        int minSpread = Integer.MAX_VALUE;

        for(WeatherData data: weatherDataList) {
            if (data.getSpread() < minSpread) {
                minSpread = data.getSpread();
                minSpreadDay = data.getDay();
            }
        }
        return minSpreadDay;
    }

    public static String getTeamWithSmallestDifferenceOfGoals(List<FootballData> footballDataList) {
        String minTeamName = "DEFAULT";
        int minGoalSpread = Integer.MAX_VALUE;

        for (FootballData data: footballDataList) {
            if (data.getSpread() < minGoalSpread) {
                minGoalSpread = data.getSpread();
                minTeamName = data.getName();
            }
        }
        return minTeamName;
    }

    public static <T extends Data> String getIdentifierWithSmallestSpread(List<T> dataList) {
        String minIdentifier = null;
        int minSpread = Integer.MAX_VALUE;

        for (T data : dataList) {
            if (data.getSpread() < minSpread) {
                minSpread = data.getSpread();
                minIdentifier = data.getId();
            }
        }
        return minIdentifier;
    }
}
