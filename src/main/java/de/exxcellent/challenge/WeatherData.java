package de.exxcellent.challenge;

public class WeatherData {
    private int day;
    private int maxTemp;
    private int minTemp;

    public WeatherData(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getTempSpread() {
        return (maxTemp - minTemp);
    }
}
